package com.ra.service.impl;

import com.ra.exception.BaseException;
import com.ra.exception.ErrorCode;
import com.ra.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageServiceImpl.class);
    private final Path root = Paths.get("uploads");

    public FileStorageServiceImpl() {
        try {
            Files.createDirectories(root);
        } catch (Exception ex) {
            LOGGER.error("FileStorageServiceImpl createDirectories with ex: {}", ex);
            throw new BaseException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        } catch (FileAlreadyExistsException ex) {
            LOGGER.warn(ex.getMessage());
        }
        catch (Exception ex) {
            LOGGER.error("FileStorageServiceImpl save with ex: {}", ex);
            throw new BaseException(ErrorCode.UPLOAD_ERROR);
        }
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable())
                return resource;
            else
                throw new BaseException(ErrorCode.LOAD_FILE_ERROR);
        } catch (Exception ex) {
            LOGGER.error("FileStorageServiceImpl save with ex: {}", ex);
            throw new BaseException(ErrorCode.UPLOAD_ERROR);
        }
    }
}

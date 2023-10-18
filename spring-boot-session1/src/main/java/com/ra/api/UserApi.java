package com.ra.api;

import com.ra.config.ErrorMessage;
import com.ra.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    public static List<User> users = new ArrayList<>();

    private ErrorMessage errorMessage;

    public UserApi(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    public User postUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }
    @PutMapping("/{id}")
    public User putUser(@PathVariable String id, @RequestBody User user) {
        User u = users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (u != null) {
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            return user;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable String id) {
        User u = users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (u != null) {
            users.remove(u);
            return u;
        }
        return null;
    }
}

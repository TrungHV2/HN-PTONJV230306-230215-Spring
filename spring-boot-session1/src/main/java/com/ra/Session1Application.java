package com.ra;

import com.ra.util.Generator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {""})
public class Session1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Session1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Generator.genOrderId());
	}
}

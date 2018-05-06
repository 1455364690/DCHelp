package com.competition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class VersionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VersionApplication.class, args);
	}
}

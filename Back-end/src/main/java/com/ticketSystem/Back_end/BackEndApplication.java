package com.ticketSystem.Back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		Path path = Paths.get("config.json");
		if(path.toFile().exists()){
			System.out.println("Hello");
		}
		else {
			SpringApplication.run(BackEndApplication.class, args);
		}
	}

}

package com.sunchips.apiv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Apiv1Application {

	public static void main(String[] args) {
		 System.out.println("SPOTIFY_CLIENT_SECRET = " + System.getenv("SPOTIFY_CLIENT_SECRET"));
		SpringApplication.run(Apiv1Application.class, args);
	}

}

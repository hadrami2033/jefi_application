package com.example.demo;

import java.sql.Date;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JeffiAppApplication {
	
	public static Date date = new Date(System.currentTimeMillis());
	
	public static void main(String[] args) {
		SpringApplication.run(JeffiAppApplication.class, args);
	}

}

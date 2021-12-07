package com.icn.barleystation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BarleystationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarleystationApplication.class, args);
	}

}

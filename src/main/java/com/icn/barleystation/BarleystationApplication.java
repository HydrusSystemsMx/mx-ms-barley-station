package com.icn.barleystation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class BarleystationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarleystationApplication.class, args);
	}

}

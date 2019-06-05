package com.momo.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
//@EnableScheduling //开启定时器
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	public DataLoader dataLoader() {
		return new DataLoader();
	}

	@Slf4j
	static class DataLoader implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			log.info("Loading data...");
		}
	}
}

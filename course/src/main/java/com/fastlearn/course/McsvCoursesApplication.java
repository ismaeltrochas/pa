package com.fastlearn.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McsvCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvCoursesApplication.class, args);
	}

}

package com.fastlearn.mediauploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MediaUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaUploaderApplication.class, args);
	}

}

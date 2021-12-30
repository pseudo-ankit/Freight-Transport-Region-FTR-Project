package com.FTR.Workitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkitemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkitemsApplication.class, args);
	}

}

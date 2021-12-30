package com.FTR.Vehicles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VehiclesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TO DO Something....
	}
}

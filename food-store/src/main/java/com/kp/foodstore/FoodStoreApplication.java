package com.kp.foodstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FoodStoreApplication {
	private static final Logger LOG = LoggerFactory.getLogger(FoodStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FoodStoreApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner appOutput() {
		return (args)-> {
			LOG.info("Starting initializing...");
		};
	}
	

}

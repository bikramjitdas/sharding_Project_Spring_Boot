package com.example.sharding_project;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class }, 
scanBasePackages= {
		"com.example.sharding_project"})
public class ShardingProjectApplication {
	private final static Logger logger = LoggerFactory.getLogger(ShardingProjectApplication.class);
	public static void main(String[] args) {
		logger.info("Sharding project app started");
		SpringApplication.run(ShardingProjectApplication.class, args);
	}

}

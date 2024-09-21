package com.redis_cache.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
//@EntityScan(basePackages = "com.redis_cache.poc.model") // Scan for entities
//@EnableJpaRepositories(basePackages = "com.redis_cache.poc.adapter") // Scan for repositories

@EnableCaching
public class RedisChachePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisChachePocApplication.class, args);
	}

}

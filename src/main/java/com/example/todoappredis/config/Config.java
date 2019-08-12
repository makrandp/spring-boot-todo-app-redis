package com.example.todoappredis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;
	
    public Config() {
		LOGGER.info("Config Class Constructor");
	}
    
	public String getRedisHost() {
		return redisHost;
	}

	public int getRedisPort() {
		return redisPort;
	}
}

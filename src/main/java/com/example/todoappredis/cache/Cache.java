package com.example.todoappredis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.todoappredis.config.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

@Component
public class Cache implements ICache {
	
	private ObjectMapper objectMapper;
    private Jedis jedis;
    private String redisHost;
    private int redisPort;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	public Cache(Config config){
		LOGGER.info("Cache class constructor");
		
		this.redisHost = config.getRedisHost();
		this.redisPort = config.getRedisPort();
		
		jedis = new Jedis(this.redisHost, this.redisPort);
		objectMapper = new ObjectMapper();
	}

	public Jedis getJedis() {
		return jedis;
	}
	
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	@Override
	public Object getItem(String key, Class type) {
		String jsonObject = jedis.get(key);
		//converting jsonObject to Object of Class type
        try {
            return objectMapper.readValue(jsonObject, type);
        } catch (Exception e){
        	LOGGER.info("Exception Occurred : " + e.getMessage());
            return null;
        }
	}

	@Override
	public Object setItem(String key, Object item) {
		//Converting Object to JSON String
		try {
            String jsonItem = objectMapper.writeValueAsString(item);
        	LOGGER.info("Json Item : " + jsonItem);
            String result = jedis.set(key, jsonItem);
            LOGGER.info("result : "+result);
            return objectMapper.readValue(jsonItem, item.getClass());
        } catch (Exception e){
        	LOGGER.info("Exception Occurred : " + e.getMessage());
            return null;
        }
	}

	@Override
	public boolean deleteItem(String key) {
		Long result = jedis.del(key);
		LOGGER.info("jedis del result : " + result);
		return true;
	}
	
	
}

package com.example.todoappredis.cache;

public interface ICache {
	
	public Object getItem(String key, Class type);
    public Object setItem(String key, Object item);
    public boolean deleteItem(String key);
}

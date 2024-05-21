package com.example.myCache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LRUCacheService {

    private final LRUCache lruCache;

    @Autowired
    public LRUCacheService(@Value("${lru.cache.capacity:10}") int capacity) {
        this.lruCache = new LRUCache(capacity);
    }

    public void putData(int key, int value) {
        lruCache.putData(key, value);
    }

    public int getData(int key) {
        return lruCache.getData(key);
    }

    public int evictData(int key) {
        return lruCache.removeData(key);
    }
}

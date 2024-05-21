package com.example.myCache.controller;

import com.example.myCache.service.LRUCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class LRUCacheController {

    @Autowired
    private LRUCacheService lruCacheService;

    @PostMapping("/put")
    public void putData(@RequestParam int key, @RequestParam int value) {
        lruCacheService.putData(key, value);
    }

    @GetMapping("/get")
    public int getData(@RequestParam int key) {
        return lruCacheService.getData(key);
    }

    @DeleteMapping("/evict")
    public int evictData(@RequestParam int key) {
        return lruCacheService.evictData(key);
    }
}

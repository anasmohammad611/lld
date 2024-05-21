package com.example.myCache.service.interfaces;

public interface Storage {
    void putData(int key, int value);
    int removeData(int key);
    int getData(int key);
}

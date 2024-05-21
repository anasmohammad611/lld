package com.example.myCache.service;

import com.example.myCache.model.DLLNode;
import com.example.myCache.model.DLinkedList;
import com.example.myCache.service.interfaces.Storage;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class LRUCache implements Storage {
    private int capacity;
    private int count;
    private HashMap<Integer, DLLNode> cache;
    private DLinkedList dLinkedList;

    public LRUCache() {
        this(10);
    }

    public LRUCache(int cap) {
        capacity = cap;
        count = 0;
        cache = new HashMap<>(capacity);
        dLinkedList = new DLinkedList();
    }

    @Override
    public void putData(int key, int value) {
        DLLNode dllNode = dLinkedList.insert(key, value);
        if(!cache.containsKey(key)) {
            cache.put(key, dllNode);
            count += 1;
            if(count > capacity) {
                DLLNode poppedNode = dLinkedList.popTail();
                cache.remove(poppedNode.getKey());
                count -= 1;
            }
        }
        dLinkedList.moveToHead(dllNode);
    }

    @Override
    public int removeData(int key) {
        if(!cache.containsKey(key))
            throw new NoSuchElementException();

        DLLNode dllNode = cache.get(key);
        cache.remove(key);
        dLinkedList.remove(dllNode);

        return dllNode.getValue();
    }

    @Override
    public int getData(int key) {
        if(!cache.containsKey(key))
            return -1;

        DLLNode dllNode = cache.get(key);
        dLinkedList.moveToHead(dllNode);
        return dllNode.getValue();
    }
}

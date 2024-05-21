package com.example.myCache.model;



public class DLLNode {
    private int key;
    private int value;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public DLLNode getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return "DLLNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

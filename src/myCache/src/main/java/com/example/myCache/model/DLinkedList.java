package com.example.myCache.model;

public class DLinkedList {
    private DLLNode head;
    private DLLNode tail;

    public DLinkedList() {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);

        head.setNext(tail);
        tail.setPrev(head);
    }

    public DLLNode insert(int key, int value) {
        DLLNode dllNode = new DLLNode(key, value);
        
        dllNode.setNext(head.getNext());
        dllNode.setPrev(head);

        head.getNext().setPrev(dllNode);
        head.setNext(dllNode);

        return dllNode;
    }

    public void remove(DLLNode dllNode) {
        DLLNode next = dllNode.getNext();
        DLLNode prev = dllNode.getPrev();

        next.setPrev(prev);
        prev.setNext(next);
    }

    public void moveToHead(DLLNode dllNode) {
        remove(dllNode);
        dllNode.setNext(head.getNext());
        dllNode.setPrev(head);
        head.getNext().setPrev(dllNode);
        head.setNext(dllNode);
    }

    public DLLNode popTail() {
        DLLNode dllNode = tail.getPrev();
        remove(dllNode);
        return dllNode;
    }
}

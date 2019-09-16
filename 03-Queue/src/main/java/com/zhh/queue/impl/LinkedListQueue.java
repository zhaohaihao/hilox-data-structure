package com.zhh.queue.impl;

import com.zhh.queue.Queue;

/**
 * @author zhh
 * @description 链表实现队列
 * @date 2019-09-17 01:03
 */
public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 头结点, 尾结点
     */
    private Node head, tail;

    /**
     * 链表大小
     */
    private int size;

    public LinkedListQueue() {}

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("无法从空栈中取出元素");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null) {
            tail = null;
        }
        size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");

        Node current = head;
        while (current != null) {
            res.append(current + " -> ");
            current = current.next;
        }

        res.append("NULL tail");

        return res.toString();
    }


    /**
     * 节点
     */
    private class Node {

        /**
         * 元素
         */
        public E e;

        /**
         * 节点引用
         */
        public Node next;

        public Node() {
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}

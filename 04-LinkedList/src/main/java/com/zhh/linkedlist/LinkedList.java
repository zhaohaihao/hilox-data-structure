package com.zhh.linkedlist;

import java.util.StringJoiner;

/**
 * @author zhh
 * @description 链表
 * @date 2019-09-16 18:31
 */
public class LinkedList<E> {

    /**
     * 虚拟头节点
     */
    private Node dummyHead;

    /**
     * 链表大小
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node();
    }

    /**
     * 获取链表中的元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的第index(从0开始计)位置添加新元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败, 索引异常");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size++;
    }

    /**
     * 在链表的头部添加新元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表的末尾添加新元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表第index(从0开始计)位置的元素
     *
     * @param index 索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败, 索引异常");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(从0开始计)位置的元素为e
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败, 索引异常");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.e = e;
    }

    /**
     * 查找链表中是否存在元素e
     *
     * @param e 元素
     * @return
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringJoiner res = new StringJoiner(" -> ");

        Node current = dummyHead.next;
        while (current != null) {
            res.add(current + "");
            current = current.next;
        }

        res.add("NULL");

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

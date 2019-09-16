package com.zhh.linkedlist;

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
     * 在链表的index(从0开始计)位置添加新元素
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

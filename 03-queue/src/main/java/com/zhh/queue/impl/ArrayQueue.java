package com.zhh.queue.impl;

import com.zhh.array.Array;
import com.zhh.queue.Queue;

import java.util.StringJoiner;

/**
 * @author zhh
 * @description 数组队列
 * @date 2019-09-12 16:37
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 构造默认容量大小的队列
     */
    public ArrayQueue() {
        array = new Array();
    }

    /**
     * 构造指定容量大小的队列
     *
     * @param capacity 容量
     */
    public ArrayQueue(int capacity) {
        array = new Array(capacity);
    }

    /**
     * 获取数组队列容量的大小
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFisrt();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), getCapacity()));

        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < getSize(); i++) {
            sj.add(array.get(i) + "");
        }

        sb.append("front [");
        sb.append(sj.toString());
        sb.append("] tail");

        return sb.toString();
    }
}

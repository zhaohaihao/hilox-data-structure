package com.zhh.queue.impl;

import com.zhh.queue.Queue;

import java.util.StringJoiner;

/**
 * @author zhh
 * @description 循环队列
 * @date 2019-09-16 10:43
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 数据
     */
    private E[] data;

    /**
     * 队首元素索引, 队尾元素后一位索引
     */
    private int front, tail;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 构造默认容量大小的队列
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 构造指定容量大小的队列
     *
     * @param capacity 容量
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    /**
     * 获得容量大小
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 判断队列是否满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("无法从空栈中取出元素");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));

        StringJoiner sj = new StringJoiner(", ");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sj.add(data[i] + "");
        }

        sb.append("front [");
        sb.append(sj.toString());
        sb.append("] tail");

        return sb.toString();
    }

    /**
     * 扩容/缩减
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }
}

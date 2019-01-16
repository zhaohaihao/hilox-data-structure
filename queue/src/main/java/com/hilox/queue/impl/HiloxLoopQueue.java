package com.hilox.queue.impl;

import com.hilox.queue.base.HiloxQueue;

/**
 * 循环队列
 * Created by Hilox on 2019/1/16.
 */
public class HiloxLoopQueue<E> implements HiloxQueue<E> {

    // 承载的数据
    private E[] data;

    // 队首所在索引
    private int front;

    // 队尾所在索引
    private int tail;

    // 队列中元素个数
    private int size;

    public HiloxLoopQueue() {
        this(10);
    }

    public HiloxLoopQueue(int capacity) {
        // 循环队列会额外浪费一个空间, 如果要使队列元素个数满足capacity, 初始应当加1
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
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
        if ((tail + 1) %  data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue!");
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
            throw new IllegalArgumentException("Cannot dequeue from an empty queue!");
        }
        return data[front];
    }

    /**
     * 获取容积
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 扩容
     * @param newCapacity
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n front [", size, getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        HiloxLoopQueue<Integer> hiloxLoopQueue = new HiloxLoopQueue<>();
        for (int i = 0; i < 10; i++) {
            hiloxLoopQueue.enqueue(i);
            System.out.println(hiloxLoopQueue);

            if (i % 3 == 2) {
                hiloxLoopQueue.dequeue();
                System.out.println(hiloxLoopQueue);
            }
        }
    }
}

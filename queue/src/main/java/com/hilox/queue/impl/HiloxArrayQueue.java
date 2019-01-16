package com.hilox.queue.impl;

import com.hilox.array.HiloxArray;
import com.hilox.queue.base.HiloxQueue;

/**
 * Created by Hilox on 2019/1/15 0015.
 */
public class HiloxArrayQueue<E> implements HiloxQueue<E> {

    private HiloxArray<E> hiloxArray;

    public HiloxArrayQueue() {
        hiloxArray = new HiloxArray();
    }

    public HiloxArrayQueue(int capacity) {
        hiloxArray = new HiloxArray(capacity);
    }

    @Override
    public int getSize() {
        return hiloxArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return hiloxArray.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        hiloxArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return hiloxArray.removeFirst();
    }

    @Override
    public E getFront() {
        return hiloxArray.getFirst();
    }

    /**
     * 获取容积
     * @return
     */
    public int getCapacity() {
        return hiloxArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front [");
        for (int i = 0; i < hiloxArray.getSize(); i++) {
            sb.append(hiloxArray.get(i));
            if (i != hiloxArray.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        HiloxArrayQueue<Integer> hiloxArrayQueue = new HiloxArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            hiloxArrayQueue.enqueue(i);
            System.out.println(hiloxArrayQueue);

            if (i % 3 == 2) {
                hiloxArrayQueue.dequeue();
                System.out.println(hiloxArrayQueue);
            }
        }
    }}

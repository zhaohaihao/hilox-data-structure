package com.hilox.stack.impl;

import com.hilox.array.HiloxArray;
import com.hilox.stack.base.Stack;

/**
 * Created by Hilox on 2019/1/15.
 */
public class ArrayStack<E> implements Stack<E> {

    private HiloxArray<E> hiloxArray;

    public ArrayStack() {
        hiloxArray = new HiloxArray<>();
    }

    public ArrayStack(int capacity) {
        hiloxArray = new HiloxArray<>(capacity);
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
    public void push(E e) {
        hiloxArray.addLast(e);
    }

    @Override
    public E pop() {
        return hiloxArray.removeLast();
    }

    @Override
    public E peek() {
        return hiloxArray.getLast();
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
        sb.append("Stack: [");
        for (int i = 0; i < hiloxArray.getSize(); i++) {
            sb.append(hiloxArray.get(i));
            if (i != hiloxArray.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}

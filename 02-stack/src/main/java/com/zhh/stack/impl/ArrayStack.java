package com.zhh.stack.impl;

import com.zhh.array.Array;
import com.zhh.stack.Stack;

import java.util.StringJoiner;

/**
 * @author zhh
 * @description 数组栈
 * @date 2019-09-12 10:37
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    /**
     * 默认容量大小的栈
     */
    public ArrayStack() {
        array = new Array();
    }

    /**
     * 构造指定容量大小的栈
     *
     * @param capacity 容量
     */
    public ArrayStack(int capacity) {
        array = new Array(capacity);
    }

    /**
     * 获取栈的容积大小
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < getSize(); i++) {
            sj.add(array.get(i) + "");
        }

        sb.append("[");
        sb.append(sj.toString());
        sb.append("] top");

        return sb.toString();
    }
}

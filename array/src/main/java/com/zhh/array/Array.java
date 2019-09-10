package com.zhh.array;

import java.util.StringJoiner;

/**
 * @author zhh
 * @description 数组
 * @date 2019-09-10 15:29
 */
public class Array<T> {

    /**
     * 数据
     */
    private T[] data;

    /**
     * 大小
     */
    private int size;

    /**
     * 默认构造函数, 默认容量capacity为10
     */
    public Array() {
        this(10);
    }

    /**
     * 传入数组的容量capacity构造Array
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e 元素
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向所有元素后添加一个新元素e
     *
     * @param e 元素
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 在第index位置插入新元素e
     *
     * @param index 数组下标
     * @param e     元素
     */
    public void add(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加失败, 数组下标必须大于等于0且小于数组的大小");
        }

        if (size == getCapacity()) {
            // 数组扩容
            resize(2 * getCapacity());
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 数组下标
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加失败, 数组下标必须大于等于0且小于数组的大小");
        }

        return data[index];
    }

    /**
     * 修改index索引位置的元素
     *
     * @param index 数组下标
     * @param e     元素
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加失败, 数组下标必须大于等于0且小于数组的大小");
        }

        data[index] = e;
    }

    /**
     * 查找数组中是否存在元素e
     *
     * @param e 元素
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引, 如果不存在元素e, 则返回-1
     *
     * @param e 元素
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return
     */
    public T removeFisrt() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index 数组下标
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("添加失败, 数组下标必须大于等于0且小于数组的大小");
        }

        T result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            // 数组缩减
            resize(getCapacity() / 2);
        }

        return result;
    }

    /**
     * 从数组中删除元素e
     *
     * @param e 元素
     */
    public void removeElement(T e) {
        int index = find(e);

        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, getCapacity()));

        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            sj.add(data[i] + "");
        }

        sb.append("[");
        sb.append(sj.toString());
        sb.append("]");

        return sb.toString();
    }

    /**
     * 数组扩容/缩减
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}

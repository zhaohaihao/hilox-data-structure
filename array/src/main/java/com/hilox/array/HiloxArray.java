package com.hilox.array;

/**
 * Created by Hilox on 2018/11/29 0029.
 */
public class HiloxArray {

    // 承载的数据
    private int[] data;

    // data数组中有效元素
    private int size;

    /**
     * 无参数的构造函数, 默认数组的容量capacity为10
     */
    public HiloxArray() {
        this(10);
    }

    /**
     * 构造函数, 传入数组的容量capacity构造HiloxArray
     * @param capacity
     */
    public HiloxArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组的第一位添加一个新的元素
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向数组的最后添加一个新的元素
     * @param e 元素
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在第index个位置中插入一个新的元素e
     * @param index 下标
     * @param e 元素
     */
    public void add(int index, int e) {

        if (size == getCapacity()) {
            throw new IllegalArgumentException("Add failed. HiloxArray is full.");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }
}

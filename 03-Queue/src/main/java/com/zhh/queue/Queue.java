package com.zhh.queue;

/**
 * @author zhh
 * @description 队列
 * @date 2019-09-12 16:28
 */
public interface Queue<E> {

    /**
     * 获取队列的大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 向队列中添加元素
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 从队列中获取元素
     *
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     *
     * @return
     */
    E getFront();
}

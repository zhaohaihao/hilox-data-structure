package com.hilox.queue.base;

/**
 * Created by Hilox on 2019/1/15 0015.
 */
public interface HiloxQueue<E> {

    /**
     * 获取队列的大小
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向队列中添加元素
     * @param e
     */
    void enqueue(E e);

    /**
     * 从队列中取出元素
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     * @return
     */
    E getFront();
}

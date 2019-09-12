package com.zhh.stack;

/**
 * @author zhh
 * @description 栈
 * @date 2019-09-12 10:31
 */
public interface Stack<E> {

    /**
     * 获取栈的大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中添加元素
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 从栈中取出元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}

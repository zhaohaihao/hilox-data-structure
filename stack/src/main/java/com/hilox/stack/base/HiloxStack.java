package com.hilox.stack.base;

/**
 * Created by Hilox on 2019/1/15.
 */
public interface HiloxStack<E> {

    /**
     * 获取栈的大小
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 向栈中添加元素
     * @param e
     */
    void push(E e);

    /**
     * 从栈中取出元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}

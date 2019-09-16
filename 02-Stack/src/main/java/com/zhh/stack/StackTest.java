package com.zhh.stack;

import com.zhh.stack.impl.ArrayStack;
import com.zhh.stack.impl.LinkedListStack;

import java.util.Random;

/**
 * @author zhh
 * @description 栈测试
 * @date 2019-09-17 12:50
 */
public class StackTest {

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println(String.format("ArrayStack spend %s s", stackTest(arrayStack, opCount)));

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println(String.format("LinkedListStack spend %s s", stackTest(linkedListStack, opCount)));
    }

    /**
     * 测试使用指定栈运行opCount个入栈和出栈操作所花费的时间, 单位秒
     *
     * @param stack   指定栈
     * @param opCount 操作数
     * @return
     */
    public static double stackTest(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}

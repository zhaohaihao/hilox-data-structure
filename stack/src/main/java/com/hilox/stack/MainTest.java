package com.hilox.stack;

import com.hilox.stack.impl.ArrayStack;

/**
 * Created by Hilox on 2019/1/15.
 */
public class MainTest {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }
}

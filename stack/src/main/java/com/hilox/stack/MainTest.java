package com.hilox.stack;

import com.hilox.stack.impl.HiloxArrayStack;

/**
 * Created by Hilox on 2019/1/15.
 */
public class MainTest {

    public static void main(String[] args) {
        HiloxArrayStack<Integer> hiloxArrayStack = new HiloxArrayStack<>();
        for (int i = 0; i < 5; i++) {
            hiloxArrayStack.push(i);
            System.out.println(hiloxArrayStack);
        }

        hiloxArrayStack.pop();
        System.out.println(hiloxArrayStack);
    }
}

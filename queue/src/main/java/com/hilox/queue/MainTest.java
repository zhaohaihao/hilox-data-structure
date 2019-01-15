package com.hilox.queue;

import com.hilox.queue.impl.HiloxArrayQueue;

/**
 * Created by Hilox on 2019/1/15 0015.
 */
public class MainTest {

    public static void main(String[] args) {
        HiloxArrayQueue<Integer> hiloxArrayQueue = new HiloxArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            hiloxArrayQueue.enqueue(i);
            System.out.println(hiloxArrayQueue);

            if (i % 3 == 2) {
                hiloxArrayQueue.dequeue();
                System.out.println(hiloxArrayQueue);
            }
        }
    }
}

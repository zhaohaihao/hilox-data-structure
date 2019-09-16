package com.zhh.queue;

import com.zhh.queue.impl.ArrayQueue;
import com.zhh.queue.impl.LinkedListQueue;
import com.zhh.queue.impl.LoopQueue;

import java.util.Random;

/**
 * @author zhh
 * @description 队列测试
 * @date 2019-09-16 16:47
 */
public class QueueTest {

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(String.format("ArrayQueue spend %s s", queueTest(arrayQueue, opCount)));

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(String.format("LoopQueue spend %s s", queueTest(loopQueue, opCount)));

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println(String.format("LinkedListQueue spend %s s", queueTest(linkedListQueue, opCount)));
    }

    /**
     * 测试使用指定队列运行opCount个入队和出队操作所花费的时间, 单位秒
     *
     * @param queue   指定队列
     * @param opCount 操作数
     * @return
     */
    public static double queueTest(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}

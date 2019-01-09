package com.hilox.array;

/**
 * 测试
 * Created by Hilox on 2018/12/5.
 */
public class MainTest {

    public static void main(String[] args) {
        HiloxArray<Integer> hiloxArray = new HiloxArray();
        for (int i = 0; i < 10; i++) {
            hiloxArray.addLast(i);
        }
        System.out.println(hiloxArray);

        hiloxArray.add(1, 55);
        System.out.println(hiloxArray);

        hiloxArray.addFirst(-1);
        System.out.println(hiloxArray);

        hiloxArray.remove(2);
        System.out.println(hiloxArray);

        hiloxArray.removeElement(9);
        System.out.println(hiloxArray);

        hiloxArray.removeFirst();
        System.out.println(hiloxArray);
    }
}

package com.fengjin.success.singleton.type5;

import java.util.concurrent.*;

/**
 * @author: Arno.Feng
 * @date: 2021/7/1
 * @description:验证线程不安全
 */
public class Singleton01 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10000);

    private static volatile ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {

            final int j = i;
            executorService.execute(() -> {
                try {
                    cyclicBarrier.await();
                    Singleton instance = Singleton.getInstance();
                    int hashCode = instance.hashCode();
                    if (!map.containsKey(hashCode)) {
                        map.put(hashCode, "");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
}

class Singleton {
    private static Singleton singleTon;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleTon == null) {
            synchronized (Singleton.class) {
                singleTon = new Singleton();
            }
        }
        return singleTon;
    }
}

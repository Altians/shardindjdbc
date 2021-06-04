package com.shardingjdbc.test.shardingjdbcdemo;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBlockingQueue {
    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Random random = new Random();
                        int i = random.nextInt();
                        System.out.println("生产者" + Thread.currentThread().getName() + "生产数据" + i);
                        queue.put(i);
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    } finally {
                        service.shutdown();
                    }
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Integer take = queue.take();
                        System.out.println("消费者" + Thread.currentThread().getName() + "消费数据" + take);
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    } finally {
                        service.shutdown();
                    }
                }
            });
        }
    }

    static class provider implements Runnable {

        private BlockingQueue queue;

        public provider(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

        }
    }

    static class consumer implements Runnable {

        private BlockingQueue queue;

        public consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

        }
    }
}

package com.example.demo.TestDev;

import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread startThread = new Thread(new Task("start"));
        Thread runThread = new Thread(new Task("run"));

        startThread.start(); // 开启一个新的线程
        startThread.stop();
        // new Thread
        runThread.run(); // main线程
        // current Thread

        new ReentrantLock(false);

    }

    /*
     * Simple Runnable implementation
     */
    private static class Task implements Runnable {
        private String caller;

        public Task(String caller) {
            this.caller = caller;
        }

        @Override
        public void run() {
            System.out.println("Caller: " + caller
                    + " and code on this Thread is executed by : "
                    + Thread.currentThread().getName());


        }
    }

}

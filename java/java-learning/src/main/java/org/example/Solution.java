package org.example;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class Solution {

    SynchronousQueue<Runnable> queue = new SynchronousQueue<>();
    private Semaphore secondBlock = new Semaphore(0);

    public Solution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        queue.add(printFirst);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        queue.add(printSecond);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        queue.add(printThird);

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

package learn.service;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadService {

    private final AtomicInteger counter = new AtomicInteger(0);

    public int calculateInThreads() throws InterruptedException {
        int repeatCounter = 1000;
        int numberOfThreads = 100;

        Runnable runnable = () -> {
            for (int i = 0; i < repeatCounter; i++) {
                counter.incrementAndGet();
            }
        };

        Thread[] workers = new Thread[numberOfThreads];

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(runnable);
            workers[i].start();
        }

        for (Thread worker : workers) {
            worker.join();
        }

        return counter.get();
    }

}

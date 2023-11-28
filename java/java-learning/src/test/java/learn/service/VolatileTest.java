package learn.service;

public class VolatileTest {

    private volatile boolean processing;

    private void print() {
        while (processing) {
            System.out.println("Processing...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void logAndCompute() throws InterruptedException {
        processing = true;
        Runnable printLog = this::print;
        Thread printThread = new Thread(printLog);
        printThread.start();

        Thread computeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });
        computeThread.start();

        computeThread.join();
    }

    private void compute() {
        try {
            Thread.sleep(5000);
            processing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

package learn;

import learn.service.ThreadService;
import learn.service.VolatileTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import javax.management.monitor.Monitor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsTest {

    private Integer test;

    @Execution(ExecutionMode.CONCURRENT)
    @RepeatedTest(100)
    public void testThreads() throws InterruptedException {
        ThreadService threadService = new ThreadService();

        int result = threadService.calculateInThreads();

        Assertions.assertEquals(100000, result);
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    public void testVolatile() throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();

        volatileTest.logAndCompute();
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    public void testExecutorService() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.invoke
    }

}

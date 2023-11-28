package learn.service;

import learn.User;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicService {

    public void calculateInThreads() throws InterruptedException {

        AtomicReference<User> test = new AtomicReference<>();
        test.updateAndGet(it -> {
            it.setLogin("te");
            return it;
        });


    }

}

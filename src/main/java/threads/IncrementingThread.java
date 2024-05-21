package threads;

import java.util.concurrent.atomic.AtomicInteger;


public class IncrementingThread implements Runnable {

    // promenne Atomic jsou
    private final AtomicInteger value;

    public IncrementingThread(final AtomicInteger value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int idx = 0; idx < 1000; idx++) {
            value.incrementAndGet(); // metoda (incrementAndGet) je bezpecna pro pristup z vice vlaken
        }
        System.out.println(value.get());
    }
}

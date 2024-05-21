package thread_ivo;

import java.util.concurrent.atomic.AtomicInteger;

public class MainClasss {

    public static void main(String[] args) throws Exception {

        AtomicInteger pocitadlo = new AtomicInteger(20);

        Thread01 t1 = new Thread01(pocitadlo, "THREAD 01");
        Thread01 t2 = new Thread01(pocitadlo, "          THREAD 02");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

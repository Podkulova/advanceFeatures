package thread_ivo;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread01 extends Thread {

    private AtomicInteger counter;
    private String strInfo;

    public Thread01(AtomicInteger pocitadlo, String strInf){
        counter = pocitadlo;
        strInfo = strInf;
    }

    @Override
    public void run() {
        while (counter.get()>0) {

            Integer cislo = counter.get()-1;
            synchronized (counter) {
                // snizime hodnotu a precteme ji
                Integer iHodnota = counter.decrementAndGet();
                // zde by se dalo neco zpracovavat nad danym cislem

                System.out.println(strInfo + " - " + iHodnota);
            }
            // cekam dokud druhy thread nedekrementuje pocitadlo
            while(cislo==counter.get() && counter.get()>0) {
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println( strInfo + " KONEC");
    }
}



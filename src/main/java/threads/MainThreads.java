package threads;

import threads.*;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

// Ukazka prace s Threads
public class MainThreads {

    public static void main(String[] args) throws Exception {

        // lepe poustet jednotlive a v nestatickych metodach

        //threadTest();
        //runableTest();
        //waitNotifTest();
        //executorTest();
        //executorCallableTest();
        //atomicTest();

    }
    public static void threadTest() throws Exception{

        // thread 01 - vytvorima a nastartujemae vlakno
        MyThread thread1 = new MyThread("   - THREAD 01", 10);
        thread1.start();

        // thread 02 - vytvorima a nastartujemae vlakno
        MyThread thread2 = new MyThread("   - THREAD 02", 20);
        thread2.start();

        thread1.join(); // ceka na ukonceni vlakna 1
        thread2.join(); // ceka na ukonceni vlakna 1

        // pokud prohram bezi dal jako zde - neni treba cekat na ukonceni (join)
        /*
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                System.out.println("              - " + i );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        */
    }
    public static void runableTest() throws Exception {

        // vlakna je mozne spoustet i pomoci runnable
        // pouziti tridy implementujici runnable
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        // implementace runnable
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Implementace runable 02");
            }
        });
        t2.start();

        t1.join(); // ceka na ukonceni vlakna 1
        t2.join(); // ceka na ukonceni vlakna 1
    }


    public static void waitNotifTest(){

        // ukazka komunikace mezi thready cekani/pokracovani
        GunFight gunFight = new GunFight();
        // prvni vlakno vola metodu file objektu gunFight- ta se púo chvili zastavi a ceka
        new Thread() {
            @Override public void run() {
                // thread 1 (zavola metodu fire a ukonci se)
                // ale je v ni volana metoda wait proto uvnitr ceka
                gunFight.fire(30, 60); }
        }
        .start();

        // druhe vlakno vola reload cimz zajisti pokracovani metody v objektu gunFight
        new Thread() {
            @Override public void run() {
                // thread 2 (zavola metodu reload a ukonci se)
                gunFight.reload(); }
        }
        .start();
    }

        /* //  moznosti vytvareni ruznych typu Executor service
           // *********************************************************
         final ExecutorService singleThreadES = Executors.newSingleThreadExecutor(); // single thread pool
         final ExecutorService executorService = Executors.newFixedThreadPool(cpus); // pool with threads equal to cpu
         final ExecutorService cachedES = Executors.newCachedThreadPool();           // cached thread pool
         final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(cpus); // scheduled thread pool with cpu equal number of threads
        * */
    public static void executorTest() {
        // spravuje nase vlakna v nasi aplikaci
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // vytvoreni vlakna
        executor.execute(new Runnable() {
            public void run() {
                for (int i=0; i<20;i++){
                    System.out.println("Asynchronous task 01 ");
                    try{
                        Thread.sleep(10);
                    }catch (Throwable t){

                    }
                }
            }
        });
        // vytvoreni druheho vlakna
        executor.execute(new Runnable() {
            public void run() {
                for (int i=0; i<20;i++){
                    System.out.println("Asynchronous task 02 ");
                    try{
                        Thread.sleep(10);
                    }catch (Throwable t){

                    }
                }
            }
        });

        // zastaveni vsech vlaken v executor service
        executor.shutdownNow();
        /*
        shutdown()- fond vláken přestane přijímat nové úlohy, ty zahájené budou dokončeny a fond bude uzavřen
        shutdownNow()- Podobně jako shutdown, ExecutorServicepřestane přijímat nové úkoly, navíc se pokusí zastavit všechny aktivní úkoly,
                       zastaví zpracování čekajících úkolů a vrátí seznam úkolů čekajících na provedení.

        fond vláken= ExecutorService
         */

    }
    public static void executorCallableTest() throws Exception {
        // vytvoreni ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // spoustime vlakno jako rozhrani Callable (nikoli jako Runnable)
        // coz nam dovoli vratit hodnotu. Je potreba vratit Future
        Future<Integer> future = executor.submit(()->{
            // z tela metody se vraci int
            int x = 0;
            for(int i=0; i<1000; i++) {
                x=x+5;
            }
            return x;
        });


        // future.isDone() = true kdyz dobehne vlakno
        // tato smycka jede tak dlouho dokud neskonci vlakno ktere vraci promennou (future)
        while (!future.isDone()){
            // smycka - v praxi ale pojede profram dal a muze se doptavat na hodnotu (future)
            Thread.sleep(10);
        }
        // vypis hodnoty
        System.out.println(future.get());

    }

    public static void atomicTest() throws Exception {

        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        // atomicky typ zabezpeci bezpecny pristu vice vlaken k jedne promenne
        // pristup k tomuto objektu je synchronizovan
        // zde ji vytvorime
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        // stejnou instanci posleme do vice vlaken
        // vlakny s ni pracuji bezpecne protoze je typu Atomic

        executorService.submit(new IncrementingThread(atomicInteger));
        executorService.submit(new IncrementingThread(atomicInteger));

        executorService.shutdown();

    }


}

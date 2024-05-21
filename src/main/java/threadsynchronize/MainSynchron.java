package threadsynchronize;

// Ukazka synchronnizace vlaken
public class MainSynchron {
    public static void main(String args[]) throws InterruptedException {

        // Vytvorime jeden objekt typu Table
        // objekt ma metodu printTable kterou volaji vlakna

        Table tableInstance = new Table();

        // objekt Table predame do dvou vlaken
        // obe vlakna volaji jednu metodu (printTable) objektu Table
        // pokud tuto metodu definujeme jako synchronized zmeni se chovani
        MyThread1 t1=new MyThread1(tableInstance);
        MyThread2 t2=new MyThread2(tableInstance);
        // start vlaken
        t1.start();
        Thread.sleep(10); // pockame na start prvniho vlakna
        t2.start();
    }
}

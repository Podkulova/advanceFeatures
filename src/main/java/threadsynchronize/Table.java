package threadsynchronize;

public class Table{

    // pouzijem metodu se synchronized - zmeni chovani,
    // metoda se nebude volat najednou z dvou vlaken
    //
    //synchronized void printTable(String str){//synchronized method
    void printTable(String str){//synchronized method

        for(int i=1;i<=5;i++){
            System.out.println(str + i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

        /*
        // dalsi moznost synchronizace
        synchronized (this) {
            // kod ktery bude synchronizovan
        }*/

    }
}
package composition;

import java.io.Closeable;
import java.io.IOException;

public class Computer implements Closeable {
    private Proccessor proccessor;
    private Memory memory;

    public Computer(){
        proccessor = new Proccessor();
        memory = new Memory(555);
    }

    public Computer(Proccessor aProccessor,  Memory aMemory){
        proccessor = aProccessor;
        memory = aMemory;
    }



    public Proccessor getProccessor() {
        return proccessor;
    }

    public void setProccessor(Proccessor proccessor) {
        this.proccessor = proccessor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    // -------------------------------------------------------------------
    public Integer getMemorySize(){
        if(memory!=null)
            return memory.capacity;
        else
            return 0; // nebo vyhodíme chybu (exception)
    }

    @Override
    public void close() throws IOException {
        // uzavrit cokoli
    }
}

package threads;

import java.util.concurrent.Callable;

// callable je podone rozhrani jako runnable, ma metodu call
// ktera na rozdil od Runnable muze vracet hodnotu
public class CallableClass implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "nejaky retezec";
    }
}

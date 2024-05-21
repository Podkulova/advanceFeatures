package threads;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(" - RUNNABLE " + i + " - thread id:" + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("RUNABLE - " + Thread.currentThread().getId() + " FINISHED ");
        }catch (Exception ex){
            System.out.println("EXCEPTION " + ex.getMessage());
        }
    }
}

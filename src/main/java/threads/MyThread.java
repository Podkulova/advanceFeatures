package threads;

public class MyThread extends Thread{

    private String someString = "";
    private Integer count = 10;

    public MyThread(){
    }

    public MyThread(String str, Integer acount){
        someString = str;
        count = acount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(someString + " - " + i + " - thread id:" + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("THREAD - " + someString + " - " + Thread.currentThread().getId() + " FINISHED ");
        }catch (Exception ex){
            System.out.println("EXCEPTION " + ex.getMessage());
        }
    }
}

package threads;

public class PrintDemo {

    public void printCount() {
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("Counter   ---   "  + i + " thread > " +  Thread.currentThread().getId());
            }
        } catch (Exception e) {
            System.out.println("Exception thread > " +  Thread.currentThread().getId());
        }
    }
}

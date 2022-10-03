package alexshabinskiy;

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException {
     //   Thread thread = new Thread(() -> System.out.println("hello from thread"));// another way create
        Runnable runnable = () -> System.out.println("hello from thread");
        Thread thread = new Thread(runnable);// create
        thread.start(); // start
        Thread.sleep(12);
        thread.join();
        System.out.println("___");
    }
}

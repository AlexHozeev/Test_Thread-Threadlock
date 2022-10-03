package alexshabinskiy;

public class Interapter {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("sleep start");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
            System.out.println("thread moving on");
        });

        thread.start();
        System.out.println("try to interrupt the sleep in thread");
 //       thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
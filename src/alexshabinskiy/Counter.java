package alexshabinskiy;

import java.util.Random;

public class Counter {

    public int days;
    public int half;

     synchronized public void mix(){
        half++;
        try {
            Thread.sleep(new Random().nextInt(5));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        days+=1;
    }


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0;i<100;i++) counter.mix();
        };
        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0;i<100;i++) counter.mix();
        thread.join();
        System.out.println(counter.days);
        System.out.println(counter.half);
    }
}

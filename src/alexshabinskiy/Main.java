package alexshabinskiy;

import java.util.stream.IntStream;

public class Main {
public static int a = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a++;
                try {
                    Thread.sleep(1);
                    System.out.println(a);
                }catch (InterruptedException e){

                }

            }
        });
        thread.start();
        IntStream.range(1,1001).forEach(s->{
                try {
                    Thread.sleep(3);
                    a++;
                } catch (InterruptedException e) {
                }
        });
        thread.join();
        System.out.println(a);
    }
}

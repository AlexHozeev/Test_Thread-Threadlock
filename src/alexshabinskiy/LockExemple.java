package alexshabinskiy;

import java.util.concurrent.locks.ReentrantLock;

public class LockExemple {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private int salary;


    public void addSalary(int salary) {
        reentrantLock.lock();
        int increasedSalary = this.salary + salary;
        this.salary = increasedSalary;
        reentrantLock.unlock();
    }

    public void decreaseSalary(int salary) {
        int decreaseSalary = this.salary - salary;
        this.salary = decreaseSalary;
    }

    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) throws InterruptedException {
        LockExemple lockExemple = new LockExemple();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1001; i++) {
                lockExemple.addSalary(1);
            }
        });
        thread.start();

        for (int i = 0; i < 1001; i++) {
            lockExemple.decreaseSalary(1);
        }

        thread.join();
        System.out.println(lockExemple.getSalary());
    }
}

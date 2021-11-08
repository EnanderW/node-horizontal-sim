package me.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Node implements Runnable {

    private String name;

    private Thread thread;
    private ReentrantLock lock;
    private List<Integer> numbersToEvaluate;

    public Node(String name) {
        this.name = name;
        this.numbersToEvaluate = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void start() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {

        while (true) {
            Integer num = pop();
            if (num != null) {
                boolean isPrime = Util.isPrime(num);
                System.out.println("(" + name + ") " + num + (isPrime ? " is a prime number." : " is not a prime number."));
            }

        }

    }

    public void push(int num) {
        lock.lock();
        numbersToEvaluate.add(num);
        lock.unlock();
    }

    private Integer pop() {
        lock.lock();
        if (numbersToEvaluate.isEmpty()) {
            lock.unlock();
            return null;
        }

        Integer num = numbersToEvaluate.get(0);
        numbersToEvaluate.remove(0);
        lock.unlock();
        return num;
    }

}

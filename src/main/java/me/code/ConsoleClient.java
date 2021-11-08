package me.code;

import java.util.Scanner;

public class ConsoleClient implements Runnable {

    private Scanner scanner;
    private Thread thread;

    public ConsoleClient() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            int num = scanner.nextInt();

            NodeManager.INSTANCE.push(num);
        }
    }
}

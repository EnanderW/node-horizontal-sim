package me.code;

public class Main {

    public static void main(String[] args) {
        NodeManager.INSTANCE.start();

        new ConsoleClient().start();
    }

}

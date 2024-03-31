package com.jforj.singleton.eager;

public class Main {
    public static void main(String[] args) {
        printSingleton();
        printSingleton();
        printSingleton();
    }

    public static void printSingleton() {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.print();
    }
}

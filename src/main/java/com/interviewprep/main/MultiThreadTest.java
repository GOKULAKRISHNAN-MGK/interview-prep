package com.interviewprep.main;

public class MultiThreadTest {
    public static void main(String[] args) {
        /*A a = new A();
        B b = new B();
        a.start();
        b.start();*/
        ThreadDemo t1 = new ThreadDemo("Thread-1");
        t1.start();
        
        ThreadDemo t2 = new ThreadDemo("Thread-2");
        t2.start();
    }
}

class A extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Bye");
        }
    }
}

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating "+threadName);
    }

    public void run() {
        System.out.println("Running "+threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: "+threadName+", "+i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: "+threadName+" Interrupted.");
        }
        System.out.println("Thread: "+threadName+" Exiting.");
    }

    public void start() {
        System.out.println("Starting "+threadName);
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

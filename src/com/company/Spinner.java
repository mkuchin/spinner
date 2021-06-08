package com.company;

public class Spinner implements AutoCloseable {

    private final Thread thread;
    private final SpinnerRunnable spinRunner;

    public Spinner() {
        spinRunner = new SpinnerRunnable();
        thread = new Thread(spinRunner);
    }

    public void start(String message) {
        spinRunner.update(message);
        thread.start();
    }

    public void update(String message) {
        spinRunner.update(message);
    }

    @Override
    public void close() {
        thread.interrupt();
    }

    public void done() {
        spinRunner.done();
    }

    public void fail() {
        spinRunner.fail();
    }
}

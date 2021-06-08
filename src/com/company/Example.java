package com.company;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        try(var spinner = new Spinner()) {
            spinner.start("Loading unicorns");
            Thread.sleep(5000);
            spinner.update("Loading rainbows");
            Thread.sleep(5000);
            spinner.done();
        }
    }
}

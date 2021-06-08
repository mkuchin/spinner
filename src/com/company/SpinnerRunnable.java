package com.company;

import static java.lang.Thread.*;

public class SpinnerRunnable implements Runnable {
    private int frameIndex = 0;
    private String message;

    public SpinnerRunnable() {
    }

    public void update(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                step();
                sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void step() {
        System.out.print("\r" + Symbols.spinFrames.get(frameIndex) + ' ' + message);
        frameIndex = (frameIndex + 1) % Symbols.spinFrames.size();
    }

    public void done() {
        System.out.print("\r" + Symbols.done + ' ' + message);
    }

    public void fail() {
        System.out.print("\r" + Symbols.error + ' ' + message);
    }
}

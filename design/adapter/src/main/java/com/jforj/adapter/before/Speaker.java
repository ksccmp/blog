package com.jforj.adapter.before;

public class Speaker {
    private int sound = 1;

    public void soundUp() {
        sound++;
        System.out.println("sound up, sound is " + sound);
    }

    public void soundDown() {
        if (sound > 1) {
            sound--;
        }

        System.out.println("sound down, sound is " + sound);
    }
}

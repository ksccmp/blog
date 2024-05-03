package com.jforj.adapter.before;

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();
        useSpeaker(speaker); // exception !!
    }

    public static void useSpeaker(SpeakerApplication speakerApplication) {
        speakerApplication.clickLeftButton();
        speakerApplication.clickRightButton();
        speakerApplication.clickRightButton();
        speakerApplication.clickRightButton();
        speakerApplication.clickLeftButton();
    }
}

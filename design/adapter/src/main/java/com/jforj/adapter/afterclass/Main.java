package com.jforj.adapter.afterclass;

public class Main {
    public static void main(String[] args) {
        SpeakerApplication speakerApplication = new SpeakAdapter();
        useSpeaker(speakerApplication);
    }

    public static void useSpeaker(SpeakerApplication speakerApplication) {
        speakerApplication.clickLeftButton();
        speakerApplication.clickRightButton();
        speakerApplication.clickRightButton();
        speakerApplication.clickRightButton();
        speakerApplication.clickLeftButton();
    }
}

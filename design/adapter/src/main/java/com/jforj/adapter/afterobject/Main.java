package com.jforj.adapter.afterobject;

public class Main {
    public static void main(String[] args) {
        SpeakerApplication speakerApplication = new SpeakAdapter(new Speaker());
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

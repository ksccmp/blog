package com.jforj.adapter.afterobject;

public class SpeakAdapter implements SpeakerApplication {
    private Speaker speaker;

    public SpeakAdapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void clickRightButton() {
        speaker.soundUp();
    }

    @Override
    public void clickLeftButton() {
        speaker.soundDown();
    }
}

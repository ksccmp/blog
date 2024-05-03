package com.jforj.adapter.afterclass;

public class SpeakAdapter extends Speaker implements SpeakerApplication {
    @Override
    public void clickRightButton() {
        super.soundUp();
    }

    @Override
    public void clickLeftButton() {
        super.soundDown();
    }
}

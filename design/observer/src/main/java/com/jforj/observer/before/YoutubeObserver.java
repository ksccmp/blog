package com.jforj.observer.before;

public class YoutubeObserver implements SubscriberObserver {

    @Override
    public void print() {
        System.out.println("hello. i am " + getId() + " of youtube");
    }

    @Override
    public String getId() {
        return "jforj.youtube";
    }
}

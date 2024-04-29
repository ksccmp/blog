package com.jforj.observer.after;

public class TwitchObserver implements SubscriberObserver {

    @Override
    public void print() {
        System.out.println("hello. i am " + getId() + " of twitch");
    }

    @Override
    public String getId() {
        return "jforj.twitch";
    }
}

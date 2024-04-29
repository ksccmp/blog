package com.jforj.observer.after;

import java.util.ArrayList;
import java.util.List;

public class YoutubeSubject implements BroadCastingSubject {
    List<SubscriberObserver> subscriberObservers = new ArrayList<>();

    @Override
    public void addObserver(SubscriberObserver subscriberObserver) {
        System.out.println("subscribe to " + subscriberObserver.getId());
        subscriberObservers.add(subscriberObserver);
    }

    @Override
    public void deleteObserver(SubscriberObserver subscriberObserver) {
        System.out.println("subscribe cancle to " + subscriberObserver.getId());
        subscriberObservers.remove(subscriberObserver);
    }

    @Override
    public void printObserver() {
        subscriberObservers.forEach(subscriberObserver -> {
            subscriberObserver.print();
        });
    }
}

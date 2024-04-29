package com.jforj.observer.after;

public interface BroadCastingSubject {

    void addObserver(SubscriberObserver subscriberObserver);

    void deleteObserver(SubscriberObserver subscriberObserver);

    void printObserver();
}

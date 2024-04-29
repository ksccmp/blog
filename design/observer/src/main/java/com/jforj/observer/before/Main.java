package com.jforj.observer.before;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SubscriberObserver> subscriberObservers = new ArrayList<>();
        YoutubeObserver youtubeObserver = new YoutubeObserver();
        TwitchObserver twitchObserver = new TwitchObserver();

        // 구독
        System.out.println("subscribe to " + youtubeObserver.getId());
        subscriberObservers.add(youtubeObserver);

        System.out.println("subscribe to " + twitchObserver.getId());
        subscriberObservers.add(twitchObserver);

        // 출력
        subscriberObservers.forEach(subscriberObserver -> {
            subscriberObserver.print();
        });

        // 구독 취소
        System.out.println("subscribe cancle to " + youtubeObserver.getId());
        subscriberObservers.remove(youtubeObserver);

        // 출력
        subscriberObservers.forEach(subscriberObserver -> {
            subscriberObserver.print();
        });
    }
}

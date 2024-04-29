package com.jforj.observer.after;

public class Main {
    public static void main(String[] args) {
        YoutubeSubject youtubeSubject = new YoutubeSubject();
        YoutubeObserver youtubeObserver = new YoutubeObserver();

        // 구독
        youtubeSubject.addObserver(youtubeObserver);
        youtubeSubject.addObserver(new TwitchObserver());

        // 출력
        youtubeSubject.printObserver();

        // 구독 취소
        youtubeSubject.deleteObserver(youtubeObserver);

        // 출력
        youtubeSubject.printObserver();
    }
}

package com.jforj.facade.before;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Seller seller = new Seller();
        Delivery delivery = new Delivery();

        seller.checkOrder(); // 주문 확인
        seller.requestToFactory(); // 공장에 상품 생산 요청

        factory.checkOrder(); // 주문 확인
        factory.makeProduct(); // 상품 생산
        factory.sendProductToSeller(); // 상품 발송

        seller.receiveProduct(); // 상품 수령
        seller.sendProductToDelivery(); // 상품 발송

        delivery.receiveProduct(); // 상품 수령
        delivery.delivery(); // 배송
    }
}

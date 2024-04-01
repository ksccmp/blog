package com.jforj.facade.after;

public class Seller {

    public void checkOrder() {
        System.out.println("check order by seller");
    }

    public void requestToFactory() {
        System.out.println("request to factory by seller");
    }

    public void receiveProduct() {
        System.out.println("receive product from factory");
    }

    public void sendProductToDelivery() {
        System.out.println("send product to delivery by seller");
    }
}

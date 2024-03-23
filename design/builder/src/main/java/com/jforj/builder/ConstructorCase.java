package com.jforj.builder;

public class ConstructorCase {
    private long no;
    private String name;
    private String address;

    public ConstructorCase(long no) {
        this.no = no;
    }

    public ConstructorCase(long no, String name) {
        this.no = no;
        this.name = name;
    }

//    (long no, String address) 생성자와 오버로딩이 겹치기 때문에 사용 불가
//    public ConstructorCase(long no, String address) {
//        this.no = no;
//        this.address = adress;
//    }
}

package com.jforj.builder;

public class Main {
    public static void main(String[] args) {
        long no = 100L;
        String name = "myName";
        String address = "myAddress";

        checkBuilderCase(no, name, address);
        // checkConstructorCase(no, name, address);
        checkSetterCase(no, name, address);
    }

    public static void checkBuilderCase(long no, String name, String address) {
        BuilderCase builderCase1 =
                BuilderCase
                        .builder()
                        .no(no)
                        .build();

        BuilderCase builderCase2 =
                BuilderCase
                        .builder()
                        .no(no)
                        .name(name)
                        .build();

        BuilderCase builderCase3 =
                BuilderCase
                        .builder()
                        .no(no)
                        .address(address)
                        .build();
    }

//    public static void checkConstructorCase(long no, String name, String address) {
//        ConstructorCase constructorCase1 = new ConstructorCase(no);
//        ConstructorCase constructorCase2 = new ConstructorCase(no, name);
//        // ConstructorCase constructorCase3 = new ConstructorCase(no, address); 오버로딩이 겹치기 때문에 사용 불가
//    }

    public static void checkSetterCase(long no, String name, String address) {
        SetterCase setterCase1 = new SetterCase();
        setterCase1.setNo(no);

        SetterCase setterCase2 = new SetterCase();
        setterCase2.setNo(no);
        setterCase2.setName(name);

        SetterCase setterCase3 = new SetterCase();
        setterCase3.setNo(no);
        setterCase3.setAddress(address);
    }
}

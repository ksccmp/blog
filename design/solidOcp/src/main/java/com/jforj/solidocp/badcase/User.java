package com.jforj.solidocp.badcase;

public class User {

    public void attack(String job) {
        switch (job) {
            case "warrior": {
                System.out.println("칼을 이용하여 공격합니다.");
                break;
            }

            case "wizard": {
                System.out.println("지팡이를 이용하여 공격합니다.");
                break;
            }

            case "thief": {
                System.out.println("단검을 이용하여 공격합니다.");
                break;
            }

            case "archer": {
                System.out.println("활을 이용하여 공격합니다.");
                break;
            }

            default: {
                System.out.println("공격을 하지 않습니다.");
                break;
            }
        }
    }
}

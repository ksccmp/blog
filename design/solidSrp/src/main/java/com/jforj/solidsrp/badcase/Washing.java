package com.jforj.solidsrp.badcase;

public class Washing {

    public void wash(String actor, String tool, long count) {
        switch (actor) {
            case "person": {
                System.out.println("사람이 씻습니다.");
                System.out.println("도구는 " + tool + "을 사용한다고 하네요.");
                break;
            }

            case "vegetable": {
                System.out.println("채소를 씻습니다.");
                System.out.println("씻어야 되는 채소의 총 갯수는 " + count + "개 입니다.");

                if (count > 10) {
                    System.out.println("채소를 씻을 때 바구니를 사용해야 합니다.");
                }
                break;
            }

            default: {
                System.out.println("씻습니다.");
            }
        }
    }
}

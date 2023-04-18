package examples;

public class Food {
    public String name;
    public String price;
    public int calories;

    //생성자를 선언하지 않을 경우 기본 생성자 자동으로 선언됨

    public void speak() {
        System.out.println("음식이 먹어달라고 말합니다. 먹어주세요!!");
    }

    public void smell() {
        System.out.println("음식이 맛있는 냄새를 풍깁니다. 솔솔~");
    }
}

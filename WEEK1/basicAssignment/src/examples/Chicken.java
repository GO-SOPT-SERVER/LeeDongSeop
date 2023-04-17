package examples;

public class Chicken extends Food {
    public boolean isFried; //후라이드면 true, 후라이드 아니면(치킨으로 취급X) false

    public void cry() {
        System.out.println("치킨이 살아있을 때의 기억을 되살려 울어봅니다. 꼬끼오~");
    }

    @Override
    public void speak() {
        System.out.println("치킨이 말합니다. 나는 신이다..");
    }

    // 오버로딩
    public void cry(String crySound) {
        System.out.println("치킨이 새로운 울음소리를 배웠습니다. " + crySound);
    }
}

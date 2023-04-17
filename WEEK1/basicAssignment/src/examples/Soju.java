package examples;

public class Soju extends Alcohol {

    @Override
    public void makeDrunk() {
        System.out.println("OO이가~ 좋아하는~ 소주~마시기~ 소주~마시기~");
    }

    //부모 클래스의 속성과 행위를 물려받고, 더 나아가 기능을 확장하는 추상 클래스의 특징
    public String bottleColor;

    public void tornado() {
        System.out.println("소주는 회오리 한다음 먹어야 제맛이지! 휘이이잉!");
    }
}

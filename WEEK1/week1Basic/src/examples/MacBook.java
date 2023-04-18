package examples;

public class MacBook implements Laptop {
    @Override
    public void playBootSound() {
        System.out.println("빠암~~ (대충 맥북 웅장한 부팅소리)");
    }

    @Override
    public void downloadProgram() {
        System.out.println("AppStore에서 다운로드 진행중..");
    }
}

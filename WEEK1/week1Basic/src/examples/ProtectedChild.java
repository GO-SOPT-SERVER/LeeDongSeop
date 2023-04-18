package examples;

public class ProtectedChild extends ProtectedData {
    ProtectedData protectedData = new ProtectedData();

    public ProtectedChild() {
        System.out.println("protected 접근 지정자 (자식 클래스에서): " + protectedData.data);
    }
}

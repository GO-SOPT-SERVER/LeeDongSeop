import examples.*;

public class week1Basic {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("[1] 클래스와 인스턴스");
        Food food1 = new Food(); // examples.Food 클래스의 객체 생성

        // [1]-(1) 생성자
        Food food2 = new Food();
        System.out.println("// 생성자를 이용하면 서로 다른 메모리 할당 받음");
        System.out.println(System.identityHashCode(food1)); //1360767589
        System.out.println(System.identityHashCode(food2)); //873415566
        String string1 = "빅맥";
        String string2 = "빅맥";
        System.out.println("// 생성자를 이용하지 않으면 같은 메모리 할당 받음");
        System.out.println(System.identityHashCode(string1)); //818403870
        System.out.println(System.identityHashCode(string2)); //818403870

        //생성자를 정의하지 않은 경우
//        Clothes clothes = new Clothes();
//        clothes.name = "슬랙스";
//        clothes.brand = "무신사스탠다드";
//        clothes.price = 33000;
//        clothes.stock = 100;
//        clothes.addPrice();
//        clothes.sell();
        //생성자를 선언해준 경우 (훨씬 간편)
        Clothes clothes = new Clothes("슬랙스", "무신사스탠다드", 33000, 100);
        clothes.addPrice();
        clothes.sell();
        clothes.printClothesInfo();

        System.out.println("=====================================");
        System.out.println("[2] 추상화");
        System.out.println("// 현실에서 음식이 가지고 있는 속성과 행위는 정의된 Food 클래스보다 훨씬 많지만 (flavor 등..) 필요한 가장 본질적이고 공통적인 부분만을 사용");

        System.out.println("=====================================");
        System.out.println("[3] 캡슐화");
        PublicData publicData = new PublicData();
        System.out.println("public 접근 지정자: " + publicData.data); //조회 성공

        ProtectedData protectedData = new ProtectedData();
//        System.out.println("protected 접근 지정자: " + protectedData.data); 조회 불가능
        ProtectedChild protectedChild = new ProtectedChild(); //조회 성공

        DefaultData defaultData = new DefaultData();
        System.out.println("default 접근 지정자 (같은 패키지에서): " + defaultData.data); //조회 성공

        PrivateData privateData = new PrivateData();
//        System.out.println("private 접근 지정자: " + privateData.data); 조회 불가능
        System.out.println("private 접근 지정자 (getX 메소드 활용): " + privateData.getData());

        System.out.println("=====================================");
        System.out.println("[4] 상속");
        Chicken chicken = new Chicken();

        System.out.println("// Chicken 클래스가 상속받은 부모 클래스(Food)의 필드와 메소드를 사용");
        chicken.name = "황금올리브";
        System.out.println("음식의 이름은?: " + chicken.name);
        chicken.smell();

        System.out.println("// Chicken 클래스가 본인만의 필드와 메소드를 사용");
        chicken.isFried = true;
        System.out.println("이것은 후라이드입니까?: " + chicken.isFried);
        chicken.cry();

        System.out.println("// Chicken 클래스가 최상위 클래스인 Object 클래스의 메소드를 사용 (필드도 사용 가능)");
        System.out.println(chicken.toString());

        System.out.println("=====================================");
        System.out.println("[5] 다형성");

        System.out.println("// Chicken 클래스가 오버라이딩된 메소드 사용");
        System.out.println("(오버라이딩 전) ");
        food1.speak();
        System.out.println("(오버라이딩 후) ");
        chicken.speak();

        System.out.println("// Chicken 클래스가 오버로딩된 메소드 사용");
        System.out.println("(오버로딩 전) ");
        chicken.cry();
        System.out.println("(오버로딩 후) ");
        chicken.cry("뿌애앵~~");

        System.out.println("// Laptop 인터페이스를 구현한 클래스 MacBook");
        MacBook macBook = new MacBook();
        macBook.playBootSound();
        macBook.downloadProgram();

        System.out.println("// Alcohol 추상 클래스를 상속받은 Soju 클래스");
        Soju soju = new Soju();
        System.out.print("Soju 클래스가 상속받은 필드: ");
        soju.ABV = 17;
        System.out.println("소주의 도수는 " + soju.ABV + "도!");
        System.out.print("Soju 클래스가 구현한 추상 메소드 실행: ");
        soju.makeDrunk();

        System.out.print("Soju 클래스만의 필드: ");
        soju.bottleColor = "흰색";
        System.out.println("이 소주병의 색깔은 " + soju.bottleColor);
        System.out.print("Soju 클래스만의 메소드 실행: ");
        soju.tornado();

        System.out.println("// 자바 제네릭(Generic)을 활용한 Product 클래스");
        Product<String, Long> product = new Product<String, Long>();
        product.name = "이것이 자바다 책";
        product.price = 15000L;
        System.out.println("제품명: " + product.name + ", 제품 가격: " + product.price);
        Boolean isSale = product.productInfo(true);
        System.out.println("제네릭 메소드로 얻은 세일 여부: " + isSale);
    }
}

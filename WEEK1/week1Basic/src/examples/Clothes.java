package examples;

public class Clothes {
    public String name; //접근 제어자 자동으로 default
    public String brand;
    public int price;
    public int stock;

    public Clothes(String name, String brand, int price, int stock) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public void addPrice() {
        price += 1000;
    }

    public int getPrice() {
        return price;
    }

    public void sell() {
        stock--;
    }

    public void initStock() {
        stock = 100;
    }

    public int getStock() {
        return stock;
    }

    public void printClothesInfo() {
        System.out.println("// 옷 정보");
        System.out.println("이름: " + name);
        System.out.println("브랜드: " + brand);
        System.out.println("가격: " + price);
        System.out.println("재고수: " + stock);
    }
}

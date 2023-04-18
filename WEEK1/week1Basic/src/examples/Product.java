package examples;

public class Product<T, N>{
    public T name;
    public N price;

    public <E> E productInfo(E info) {
        return info;
    }
}

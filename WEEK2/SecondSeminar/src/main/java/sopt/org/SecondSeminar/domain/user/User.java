package sopt.org.SecondSeminar.domain.user;

import lombok.Getter;

@Getter
public class User {

    private Long id;

    private String name;

    private int age;

    private String address;

    private String gender;


    public User(String name, int age, String address, String gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "name: " + this.name + "\n" +
                "age: " + this.age + "\n" +
                "address: " + this.address + "\n" +
                "gender: " + this.gender;
    }
}
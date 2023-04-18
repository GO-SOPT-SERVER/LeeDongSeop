package sopt.org.week2Advanced.domain.pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {

    private Long id;

    private String name;

    private String species;

    private String gender;

    private int age;

    public Pet(String name, String species, String gender, int age) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "name: " + this.name + "\n" +
                "species: " + this.species + "\n" +
                "gender: " + this.gender + "\n" +
                "age: " + this.age;
    }
}

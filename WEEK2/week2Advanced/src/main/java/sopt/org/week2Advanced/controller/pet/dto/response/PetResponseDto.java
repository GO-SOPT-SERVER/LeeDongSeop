package sopt.org.week2Advanced.controller.pet.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.week2Advanced.domain.pet.Pet;

@Getter
@AllArgsConstructor
public class PetResponseDto {

    private Long id;

    private String name;

    private String species;

    private String gender;

    private int age;

    public PetResponseDto(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.species = pet.getSpecies();
        this.gender = pet.getGender();
        this.age = pet.getAge();
    }
}

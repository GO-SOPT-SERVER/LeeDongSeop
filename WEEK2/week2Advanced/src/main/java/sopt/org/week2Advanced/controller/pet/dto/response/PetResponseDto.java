package sopt.org.week2Advanced.controller.pet.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetResponseDto {

    private Long id;

    private String name;

    private String species;

    private String gender;

    private int age;
}

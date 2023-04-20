package sopt.org.week2Advanced.controller.pet.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterRequestDto {

    private String name;

    private String species;

    private String gender;

    private int age;
}

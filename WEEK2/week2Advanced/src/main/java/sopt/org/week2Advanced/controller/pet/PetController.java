package sopt.org.week2Advanced.controller.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.week2Advanced.controller.pet.dto.request.RegisterRequestDto;
import sopt.org.week2Advanced.controller.pet.dto.request.UpdateRequestDto;
import sopt.org.week2Advanced.controller.pet.dto.response.PetResponseDto;
import sopt.org.week2Advanced.domain.pet.Pet;
import sopt.org.week2Advanced.service.pet.PetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping("/pet")
    public String register(@RequestBody final RegisterRequestDto request) {

        Long petId = petService.register(request);
        System.out.println(petService.findOne(petId).toString());

        return petId + "번 애완동물이 등록되었습니다!";
    }

    @GetMapping("/pet/{petId}")
    public PetResponseDto getOnePet(@PathVariable final Long petId) {

        Pet findPet = petService.findOne(petId);

//        return new PetResponseDto(findPet.getId(), findPet.getName(), findPet.getSpecies(), findPet.getGender(), findPet.getAge());
        return new PetResponseDto(findPet);
    }

    @GetMapping("/pet")
    public List<PetResponseDto> getAllPet() {
        return petService.findAll();
    }

    //수정을 위한 DTO에는 id 값도 넘어와야 하므로 별도의 DTO 사용
    @PutMapping("/pet")
    public String editPet(@RequestBody UpdateRequestDto request) {

        Long petId = petService.edit(request);
        System.out.println(petService.findOne(petId).toString());

        return petId + "번 애완동물이 수정되었습니다!";
    }

    @DeleteMapping("/pet/{petId}")
    public String deletePet(@PathVariable final Long petId) {

        Boolean isDeleted = petService.delete(petId);

        return petId + "번 애완동물 삭제 여부: " + isDeleted;
    }
}

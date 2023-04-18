package sopt.org.week2Advanced.service.pet;

import org.springframework.stereotype.Service;
import sopt.org.week2Advanced.controller.pet.dto.request.RegisterRequestDto;
import sopt.org.week2Advanced.controller.pet.dto.request.UpdateRequestDto;
import sopt.org.week2Advanced.controller.pet.dto.response.PetResponseDto;
import sopt.org.week2Advanced.domain.pet.Pet;

import java.util.ArrayList;
import java.util.List;

import static sopt.org.week2Advanced.Week2AdvancedApplication.petList;

@Service
public class PetService {
    public Long register(RegisterRequestDto request) {

        // 받아온 request 데이터를 토대로 실제 Pet 객체 생성
        Pet newPet = new Pet(
                request.getName(),
                request.getSpecies(),
                request.getGender(),
                request.getAge()
        );

        // 데이터베이스에 저장
        petList.add(newPet);
        newPet.setId((long) petList.size());

        // 저장한 애완동물 아이디 값 반환
        return newPet.getId();
    }

    public Pet findOne(Long petId) {
        Pet pet = null;

        for (Pet curPet : petList) {
            if (curPet.getId().equals(petId)) {
                pet = curPet;
            }
        }

        return pet;
    }

    public List<PetResponseDto> findAll() {
        List<PetResponseDto> petDtoList = new ArrayList<>();
        for (Pet curPet : petList) {
            petDtoList.add(new PetResponseDto(curPet.getId(), curPet.getName(), curPet.getSpecies(), curPet.getGender(), curPet.getAge()));
        }

        return petDtoList;
    }

    public Long edit(UpdateRequestDto request) {
        // 받아온 request 데이터를 토대로 수정할 Pet 객체 찾기
        Pet targetPet = findOne(request.getId());

        // Pet의 필드값들 수정 (PUT 메소드이기 때문에
        targetPet.setName(request.getName());
        targetPet.setSpecies(request.getSpecies());
        targetPet.setGender(request.getGender());
        targetPet.setAge(request.getAge());

        // 수정한 애완동물 아이디 값 반환
        return targetPet.getId();
    }

    public Boolean delete(Long petId) {
        // 받아온 petId로 삭제할 Pet 객체 찾기
        Pet targetPet = findOne(petId);
        if (targetPet == null) return false;

        return petList.remove(targetPet);
    }
}

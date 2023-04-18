package sopt.org.week2Advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sopt.org.week2Advanced.domain.pet.Pet;

import java.util.ArrayList;

@SpringBootApplication
public class Week2AdvancedApplication {

	public static ArrayList<Pet> petList;

	public static void main(String[] args) {
		SpringApplication.run(Week2AdvancedApplication.class, args);

		petList = new ArrayList<>();
	}

}

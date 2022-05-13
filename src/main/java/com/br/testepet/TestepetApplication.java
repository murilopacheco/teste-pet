package com.br.testepet;

import com.br.testepet.entity.Pet;
import com.br.testepet.enums.Porte;
import com.br.testepet.repository.PetRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TestepetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestepetApplication.class, args);
	}

	@Autowired
	private PetRepository petRepository;

	@Bean
	InitializingBean sendDatabase() {
		Pet pet = new Pet();
		pet.setNome("teste pet");
		pet.setDataNascimento(LocalDate.of(2015,01,01));
		pet.setPorte(Porte.GRANDE);
		pet.setEspecie("Cão");
		pet.setAtivo(true);
		petRepository.save(pet);
		return null;
	}

}

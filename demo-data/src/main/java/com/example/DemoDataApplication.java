package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domains.entities.Veterinario;
import com.example.domains.repositories.VeterinariosRepository;

@SpringBootApplication
public class DemoDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
	}

	@Bean
	CommandLineRunner datos(VeterinariosRepository dao) {
		return (args) -> {
			var id = dao.save(new Veterinario("Pepito", "Grillo")).getId();
			dao.findAll().forEach(System.out::println);
			System.out.println("---------------------------------------");
			var item = dao.findById(id);
			if(item.isPresent()) {
				var vet = item.get();
				vet.setFirstName(vet.getFirstName().toUpperCase());
				dao.save(vet);
			} else {
				System.err.println("No encontrado");
			}
			dao.findAll().forEach(System.out::println);
			System.out.println("---------------------------------------");
			dao.deleteById(id);
			dao.findAll().forEach(System.out::println);
		};
	}
}

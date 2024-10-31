package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

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

//	@Bean
	CommandLineRunner crud(VeterinariosRepository dao) {
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
//	@Bean
	CommandLineRunner consultas(VeterinariosRepository dao) {
		return (args) -> {
			dao.findTop3ByFirstNameContainingOrderByLastNameDesc("e").forEach(System.out::println);
			System.out.println("---------------------------------------");
			dao.findByFirstNameContaining("e", Sort.by("FirstName").descending()).forEach(System.out::println);
			System.out.println("---------------------------------------");
			dao.findByIdGreaterThan(4).forEach(System.out::println);
			System.out.println("---------------------------------------");
			dao.findNuevosJPQL(4).forEach(System.out::println);
			System.out.println("---------------------------------------");
			dao.findNuevosSQL(4).forEach(System.out::println);
			System.out.println("---------------------------------------");
			dao.findAll((root, query, builder) -> builder.greaterThan(root.get("id"), 4)).forEach(System.out::println);
		};
	}
}

package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import com.example.domains.entities.Owner;
import com.example.domains.entities.Vet;
import com.example.domains.entities.Veterinario;
import com.example.domains.repositories.EspecialidadesRepository;
import com.example.domains.repositories.PropietariosRepository;
import com.example.domains.repositories.VeterinariosRepository;
import com.example.domains.repositories.VetsRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoDataApplication.class, args);
	}
	
	@Autowired
	PropietariosRepository dao;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
////		dao.findAll().forEach(System.out::println);
//		var p = dao.findById(3).get();
//		System.out.println(p);
////		p.getPets().forEach(System.out::println);
//		p = new Owner("Pepito", "Grillo");
//		if(p.isInvalid()) {
//			System.err.println(p.getErrorsMessage());
//		} else {
//			System.out.println(dao.save(p));
//		}
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
	@Bean
	@Transactional
	CommandLineRunner dependencias(VetsRepository vets, EspecialidadesRepository spc) {
		return (args) -> {
			var vet = new Vet("Pepito", "Grillo");
			vet.getSpecialties().add(spc.findById(1).get());
			vet.getSpecialties().add(spc.findById(3).get());
			vet = vets.save(vet);
			vet.getSpecialties().remove(0);
			vet.getSpecialties().add(spc.findById(2).get());
			vet = vets.save(vet);
			vets.delete(vet);
		};
	}
}

package com.example.domains.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.entities.Veterinario;

public interface VeterinariosRepository extends JpaRepository<Veterinario, Integer>, JpaSpecificationExecutor<Veterinario> {
	List<Veterinario> findTop3ByFirstNameContainingOrderByLastNameDesc(String unaLetra);
	List<Veterinario> findByFirstNameContaining(String unaLetra, Sort orderBy);
	
	List<Veterinario> findByIdGreaterThan(int id);
	@Query(value = "from Veterinario v where v.id > ?1")
	List<Veterinario> findNuevosJPQL(int id);
	@Query(value = "select * from vets v where v.id > :id", nativeQuery = true)
	List<Veterinario> findNuevosSQL(int id);
	
	
}

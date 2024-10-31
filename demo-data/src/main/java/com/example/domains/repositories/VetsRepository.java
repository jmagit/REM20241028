package com.example.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.entities.Vet;

public interface VetsRepository extends JpaRepository<Vet, Integer> {
	
}

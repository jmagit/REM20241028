package com.example.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.entities.Veterinario;

public interface VeterinariosRepository extends JpaRepository<Veterinario, Integer> {

}

package com.example.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.entities.Owner;
import com.example.domains.entities.Specialty;

public interface EspecialidadesRepository extends JpaRepository<Specialty, Integer> {

}

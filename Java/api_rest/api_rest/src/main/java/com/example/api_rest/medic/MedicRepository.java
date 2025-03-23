package com.example.api_rest.medic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    public List<Medic> findAllByAtivoTrue();
}

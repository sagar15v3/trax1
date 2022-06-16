package com.trax.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trax.entites.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}

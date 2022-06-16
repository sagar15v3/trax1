package com.trax.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trax.entites.Billing;

public interface BillingRepositories extends JpaRepository<Billing, Long> {

}

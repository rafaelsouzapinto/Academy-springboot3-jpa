package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entities.AcademyPlan;

public interface AcademyPlanRepository extends JpaRepository<AcademyPlan, Long> {

}

package com.kickstart.backend.repository;

import com.kickstart.backend.entities.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
}

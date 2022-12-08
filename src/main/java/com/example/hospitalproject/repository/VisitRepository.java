package com.example.hospitalproject.repository;
import com.example.hospitalproject.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}

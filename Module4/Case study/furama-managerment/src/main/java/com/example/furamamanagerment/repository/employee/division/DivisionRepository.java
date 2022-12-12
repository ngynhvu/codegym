package com.example.furamamanagerment.repository.employee.division;

import com.example.furamamanagerment.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
}

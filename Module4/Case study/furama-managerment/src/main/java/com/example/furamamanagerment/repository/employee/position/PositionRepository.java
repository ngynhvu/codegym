package com.example.furamamanagerment.repository.employee.position;

import com.example.furamamanagerment.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}

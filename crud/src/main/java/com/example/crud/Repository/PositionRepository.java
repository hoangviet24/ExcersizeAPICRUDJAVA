package com.example.crud.Repository;

import com.example.crud.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}

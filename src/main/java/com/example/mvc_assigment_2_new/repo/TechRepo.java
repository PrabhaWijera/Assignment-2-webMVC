package com.example.mvc_assigment_2_new.repo;

import com.example.mvc_assigment_2_new.entity.TechEntity;
import com.example.mvc_assigment_2_new.service.TechService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepo extends JpaRepository<TechEntity,String> {
}

package com.example.mvc_assigment_2_new.repo;

import com.example.mvc_assigment_2_new.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectEntity,String> {
}

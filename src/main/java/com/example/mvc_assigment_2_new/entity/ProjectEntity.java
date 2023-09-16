package com.example.mvc_assigment_2_new.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProjectEntity {

    @Id
    private String projectId;
    private String projectName;
    private String details;

    @ManyToOne
    private TechEntity techId;
}

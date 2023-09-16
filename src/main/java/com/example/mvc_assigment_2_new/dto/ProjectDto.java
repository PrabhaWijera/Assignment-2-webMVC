package com.example.mvc_assigment_2_new.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDto implements Serializable,SuperDto {
    private String projectId;
    private String projectName;
    private String details;

    private String techId;
}

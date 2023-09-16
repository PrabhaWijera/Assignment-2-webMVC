package com.example.mvc_assigment_2_new.service.impl;

import com.example.mvc_assigment_2_new.Res.ResponseController;
import com.example.mvc_assigment_2_new.dto.ProjectDto;
import com.example.mvc_assigment_2_new.entity.ProjectEntity;
import com.example.mvc_assigment_2_new.repo.ProjectRepo;
import com.example.mvc_assigment_2_new.repo.TechRepo;
import com.example.mvc_assigment_2_new.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService_impl implements ProjectService {
    @Autowired
    private ResponseController responseController;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TechRepo techRepo;
    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public ResponseController save(ProjectDto projectDto) {
        // Map the ProjectDto to ProjectEntity
        ProjectEntity projectEntity = modelMapper.map(projectDto, ProjectEntity.class);

        // Save the project entity to the database
        projectRepo.save(projectEntity);

        return createResponse(201, projectEntity, "Project saved successfully");
    }


    @Override
    public ResponseController update(ProjectDto projectDto) {
        if (projectRepo.existsById(projectDto.getProjectId())) {
            ProjectEntity existingProjectEntity = projectRepo.findById(projectDto.getProjectId()).orElse(null);
            if (existingProjectEntity != null) {
                // Update the properties of existingProjectEntity with values from projectDto
                existingProjectEntity.setProjectName(projectDto.getProjectName());
                // Continue updating other properties as needed

                // Save the updated entity back to the database
                projectRepo.save(existingProjectEntity);

                return createResponse(200, existingProjectEntity, "Project updated successfully");
            }
        }
        throw new RuntimeException("Project not found");
    }


    @Override
    public ResponseController delete(String id) {
        if (projectRepo.existsById(id)) {
            projectRepo.deleteById(id);
            return createResponse(200, null, "Project deleted successfully");
        }
        throw new RuntimeException("Project not found");
    }


    @Override
    public ResponseController search(String id) {
        Optional<ProjectEntity> project = projectRepo.findById(id);

        if (project.isPresent()) {
            return createResponse(200, project.get(), "Project found based on the search parameter");
        } else {
            return createResponse(404, null, "No project found based on the search parameter");
        }
    }



    @Override
    public ResponseController getall() {
        List<ProjectEntity> projects = projectRepo.findAll();
        if (!projects.isEmpty()) {
            return createResponse(200, projects, "All projects retrieved successfully");
        } else {
            return createResponse(404, null, "No projects found");
        }
    }


    @Override
    public ResponseController createResponse(int statusCode, Object data, String message) {
        ResponseController response = new ResponseController();
        response.setStatusCode(statusCode);
        response.setData(data);
        response.setR_Message(message);
        return response;
    }

}

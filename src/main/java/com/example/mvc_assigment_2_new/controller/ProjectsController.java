package com.example.mvc_assigment_2_new.controller;


import com.example.mvc_assigment_2_new.Res.ResponseController;
import com.example.mvc_assigment_2_new.dto.ProjectDto;
import com.example.mvc_assigment_2_new.dto.TechDto;
import com.example.mvc_assigment_2_new.service.ProjectService;
import com.example.mvc_assigment_2_new.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projectscontroller")
@CrossOrigin
public class ProjectsController {

    @Autowired
    private ProjectService projectService;



    public ProjectsController(){
        System.out.println(" project controller hit");
    }

    @GetMapping
    public String get_lead(ProjectDto projectDto){
        System.out.println(projectDto.toString());
        return "ProjectGet"+projectDto.toString();
    }



    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody ProjectDto projectDto) {
        return projectService.save(projectDto);

    }

    @PutMapping(path = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody ProjectDto projectDto){
        return projectService.update(projectDto);
    }
/*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTechLead(@PathVariable String id) {
        TechDto existingTech = techService.findById(id);
        if (existingTech == null) {
            return ResponseEntity.notFound().build();
        }
        techService.delete(id);
        return ResponseEntity.ok("Tech entry deleted successfully");
    }*/

    @GetMapping(path = "/search", params = "searchM", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@RequestParam("searchM") String projectId) {
        return projectService.search(projectId);
    }

    @DeleteMapping(path = "/delete", params = "deleteM", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@RequestParam("deleteM") String projectId) {
        return projectService.delete(projectId);
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController getAll() {
        return projectService.getall();
    }


}

package com.example.mvc_assigment_2_new.controller;


import com.example.mvc_assigment_2_new.dto.TechDto;
import com.example.mvc_assigment_2_new.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/controllerT")
public class TechController {


    @Autowired
     private TechService techService;



    public TechController(){
        System.out.println("controller hit");
    }

    @GetMapping
    public String get_lead(TechDto techDto){
        System.out.println(techDto.toString());
        return "TechGet"+techDto.toString();
    }



    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveTech_lead(@RequestBody TechDto techDto){
        techService.save(techDto);
    }

    @PutMapping(path = "update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody TechDto techDto){
        techService.update(techDto);
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




}

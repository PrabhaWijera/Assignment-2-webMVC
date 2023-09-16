package com.example.mvc_assigment_2_new.service;

import com.example.mvc_assigment_2_new.dto.TechDto;

public interface TechService {
    void save(TechDto  techDto);

    void update(TechDto techDto);

    void delete(String id);




}

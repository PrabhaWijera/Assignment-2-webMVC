package com.example.mvc_assigment_2_new.service.impl;

import com.example.mvc_assigment_2_new.dto.TechDto;
import com.example.mvc_assigment_2_new.entity.TechEntity;
import com.example.mvc_assigment_2_new.repo.TechRepo;
import com.example.mvc_assigment_2_new.service.TechService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class TechServiceimpl implements TechService {


    @Autowired
    private TechRepo techRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(TechDto techDto) {
        if (!techRepo.existsById( techDto.getT_Id())){
            System.out.println("service hti Techy");
            techRepo.save(modelMapper.map(techDto, TechEntity.class));
        }else {
            throw new RuntimeException("Tech Already in");
        }
    }

    @Override
    public void update(TechDto techDto) {

    }

    @Override
    public void delete(String id) {
        techRepo.deleteById(id);
    }

    @Override
    public void search(String id) {

    }
}

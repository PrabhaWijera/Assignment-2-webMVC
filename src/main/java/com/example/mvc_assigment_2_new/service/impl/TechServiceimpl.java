package com.example.mvc_assigment_2_new.service.impl;

import com.example.mvc_assigment_2_new.Res.ResponseController;
import com.example.mvc_assigment_2_new.dto.TechDto;
import com.example.mvc_assigment_2_new.entity.TechEntity;
import com.example.mvc_assigment_2_new.repo.TechRepo;
import com.example.mvc_assigment_2_new.service.TechService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TechServiceimpl implements TechService {

    @Autowired
    private ResponseController responseController;

    @Autowired
    private TechRepo techRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseController save(TechDto techDto) {
        if (!techRepo.existsById( techDto.getT_Id())){
            System.out.println("service hti Techy");
            techRepo.save(modelMapper.map(techDto, TechEntity.class));
        }
            throw new RuntimeException("Tech Already in");

    }

    @Override
    public ResponseController update(TechDto techDto) {
        Optional<TechEntity> optionalTechEntity = techRepo.findById(techDto.getT_Id());

        if (optionalTechEntity.isPresent()) {
            TechEntity existingTechEntity = optionalTechEntity.get();

            // Update the name property of existingTechEntity with the value from techDto
            existingTechEntity.setName(techDto.getName());
            // Continue updating other properties as needed

            // Save the updated entity back to the database
            techRepo.save(existingTechEntity);

            return createResponse(200, existingTechEntity, "Tech updated successfully");
        } else {
            throw new RuntimeException("Tech not found");
        }
    }




    @Override
    public ResponseController delete(String id) {
        if (techRepo.existsById(id)) {
            techRepo.deleteById(id);
            return createResponse(200, null, "Tech deleted successfully");
        }
        throw new RuntimeException("Tech not found");
    }
    @Override
    public ResponseController createResponse(int statusCode, Object data, String message) {
        ResponseController response = new ResponseController();
        response.setStatusCode(statusCode);
        response.setData(data);
        response.setR_Message(message);
        return response;
    }


    @Override
    public ResponseController search(String id) {
        List<TechEntity> techEntities = techRepo.findAllById(Collections.singletonList(id));

        if (!techEntities.isEmpty()) {
            return createResponse(200, techEntities, "Tech found based on the search parameter");
        } else {
            return createResponse(404, null, "Tech not found based on the search parameter");
        }
    }



    @Override
    public ResponseController getall() {
        List<TechEntity> techEntities = techRepo.findAll();
        if (!techEntities.isEmpty()) {
            return createResponse(200, techEntities, "All Tech records retrieved successfully");
        } else {
            return createResponse(404, null, "No Tech records found");
        }
    }



}

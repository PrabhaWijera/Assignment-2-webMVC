package com.example.mvc_assigment_2_new.service;

import com.example.mvc_assigment_2_new.Res.ResponseController;
import com.example.mvc_assigment_2_new.dto.SuperDto;

import javax.persistence.Id;

public interface SuperService <T extends SuperDto, ID>{
    ResponseController save(T t);

    ResponseController update(T t);
    ResponseController delete(ID id);
    ResponseController search(ID id);
    ResponseController getall();
    ResponseController createResponse(int statuscode,Object data,String message);
}

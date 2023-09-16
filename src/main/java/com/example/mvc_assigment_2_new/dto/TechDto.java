package com.example.mvc_assigment_2_new.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechDto implements Serializable, SuperDto {
    private String T_Id;
    private String Name;
    private String Email;
    private String Number;
}

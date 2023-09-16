package com.example.mvc_assigment_2_new.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class TechEntity {

    @Id
    private String T_Id;
    private String Name;
    private String Email;
    private String Number;
}

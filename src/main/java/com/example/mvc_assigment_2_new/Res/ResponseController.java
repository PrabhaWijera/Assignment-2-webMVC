package com.example.mvc_assigment_2_new.Res;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseController {
    private int StatusCode;
    private Object data;

    private String R_Message;
}

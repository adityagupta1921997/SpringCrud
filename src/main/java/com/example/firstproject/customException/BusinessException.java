package com.example.firstproject.customException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException  extends RuntimeException{

    private String errorCode;
    private String errorMessage;
}

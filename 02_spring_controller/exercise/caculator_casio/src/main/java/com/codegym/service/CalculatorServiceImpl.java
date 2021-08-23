package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public float calculator(float value1, float value2, String phepTinh) throws Exception {
        float result;
        switch (phepTinh){
            case "addition":
                result = value1 + value2;
                break;
            case "subtraction":
                result = value1 - value2;
                break;
            case "multiplication":
                result = value1 * value2;
                break;
            case "division":
                if (value2 == 0){
                    throw new Exception("Can not divide to Zero!");
                }else {
                    result = value1 / value2;
                }
                break;
            default:
                throw new Exception("Exception");
        }
        return result;
    }
}
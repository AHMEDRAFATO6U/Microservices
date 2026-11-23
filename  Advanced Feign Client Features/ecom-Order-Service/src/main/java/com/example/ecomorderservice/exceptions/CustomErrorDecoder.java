package com.example.ecomorderservice.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        if(response.status()==404){
            throw new RuntimeException("PRODUCT NOT FOUND");
        }
        throw new RuntimeException("GENERIC ERROR" +response.status());
    }
}

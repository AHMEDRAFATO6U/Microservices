package com.example.ecomorderservice.client.config;

import com.example.ecomorderservice.exceptions.CustomErrorDecoder;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.UUID;

@Configuration
public class InventoryFeignClientConfig {
    @Bean
    public Logger.Level feignInventoryLoggerLevel(){
        return Logger.Level.FULL;
    }


    @Bean
    public Request.Options options(){
        return new Request.Options(Duration.ofMillis(3000) , Duration.ofMillis(5000) ,true);
    }


    @Bean
    public Retryer retryer (){
        return new Retryer.Default(1L , 2L , 3);
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Correlation-Id", UUID.randomUUID().toString());
        };
    }


    @Bean
    public ErrorDecoder errorDecoder (){
        return new CustomErrorDecoder();
    }


    @Bean
    public Encoder encoder(){
        return new CustomInventoryEncoder();
    }

    @Bean
    public Decoder decoder(){
        return new CustomInventoryDecoder();
    }
    }


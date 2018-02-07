package com.chieftain.simple.chain.simplechain.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NestedBeans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

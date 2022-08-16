package com.EmpRec.EmployeeRecord.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi docApi(){
        return  GroupedOpenApi.builder()
                .group("employee crud functions")
                .packagesToScan("com.EmpRec.EmployeeRecord.Controller")
                .pathsToMatch("/**")
                .build();
    }
}

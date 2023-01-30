package com.example.sample.infrastructure.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.sample.adapter.out.persistence")
public class MybatisConfiguration {
}

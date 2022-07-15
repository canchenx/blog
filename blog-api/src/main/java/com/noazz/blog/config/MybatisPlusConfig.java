package com.noazz.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.noazz.blog.mapper")
public class MybatisPlusConfig {

}

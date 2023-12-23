package com.yatong.exam.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author HouYi
 * @Date .. 10:40
 * @Description SpringDoc配置类
 * @Since version-1.0
 */

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("考试系统API")
                        .version("v1.0.0"));
    }

    @Bean
    public GroupedOpenApi questionApi() {
        return GroupedOpenApi.builder()
                .group("question")
                .pathsToMatch("/question/**")
                .build();
    }
    @Bean
    public GroupedOpenApi systemApi() {
        return GroupedOpenApi.builder()
                .group("system")
                .pathsToMatch("/system/**")
                .build();
    }
}
package project.maru.presentation.middleware;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.security.SecurityScheme;

import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
public class SwaggerConfig {

  @Value("${cors-allow-domain.alb-end}")
  private String ALB_DOMAIN;

  @Bean
  public OpenAPI openAPI() {
    String jwt = "JWT";
    SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);
    Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
        .name(jwt)
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .bearerFormat("JWT")
    );
    
    Server server = new Server().url(ALB_DOMAIN);
    return new OpenAPI()
        .components(new Components())
        .info(apiInfo())
        .addSecurityItem(securityRequirement)
        .addServersItem(server)
        .components(components);
  }

  private io.swagger.v3.oas.models.info.Info apiInfo() {
    return new io.swagger.v3.oas.models.info.Info()
        .title("API Test") // API의 제목
        .description("Let's practice Swagger UI") // API에 대한 설명
        .version("1.0.0"); // API의 버전
  }
}
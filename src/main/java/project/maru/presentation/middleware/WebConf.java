package project.maru.presentation.middleware;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConf implements WebMvcConfigurer {
  @Value("${cors-allow-domain.front-end}")
  private String ALLOW_DOMAIN;

  @Value("${cors-allow-domain.test-end}")
  private String TEST_DOMAIN;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("Authorization", "Content-Type")
        //.allowCredentials(true)
        .maxAge(3600);
  }
}

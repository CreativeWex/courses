package demo05.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "demo05.service")
public class AppConfiguration {

  @Bean
  @Scope("singleton") // можно не писать — это дефолт
  public ObjectMapper singletonMapper() {
    System.out.println("Создается objectMapper singleton");
    return new ObjectMapper();
  }

  @Bean
  @Scope("prototype")
  public ObjectMapper prototypeMapper() {
    System.out.println("Создается objectMapper prototype");
    return new ObjectMapper();
  }
}

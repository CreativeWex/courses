package demo03.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo03")
public class AppConfiguration {

  @Bean
  public String color() {
    return "red";
  }
}

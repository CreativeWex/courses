package demo04.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo04.component")
public class ApplicationConfiguration {
  public ApplicationConfiguration() {
//    System.out.println("🛑 Создание бина @Configuration");
  }
}

package demo05;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo05.configuration.AppConfiguration;
import demo05.service.FirstService;
import demo05.service.SecondService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    ObjectMapper firstServiceSingletonMapper = context.getBean(FirstService.class).getSingletonMapper();
    ObjectMapper secondServiceSingletonMapper = context.getBean(SecondService.class).getSingletonMapper();
    System.out.println("Результат сравнения ссылок singleton mapper: " + (firstServiceSingletonMapper == secondServiceSingletonMapper));

    ObjectMapper firstServicePrototypeMapper = context.getBean(FirstService.class).getPrototypeMapper();
    ObjectMapper secondServicePrototypeMapper = context.getBean(SecondService.class).getPrototypeMapper();
    System.out.println("Результат сравнения ссылок prototype mapper: " + (firstServicePrototypeMapper == secondServicePrototypeMapper));
  }
}

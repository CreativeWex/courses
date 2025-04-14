package demo03;

import demo03.configuration.AppConfiguration;
import demo03.service.ColorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  // 1. Версия спринга
  // 2. Виды инжектов
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    ColorService colorService = context.getBean(ColorService.class);
    System.out.println(colorService.getColor());
  }
}

package demo02;

import demo02.component.AComponent;
import demo02.configuration.ApplicationConfiguration;
import demo02.service.AService;
import demo02.service.BService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    // ApplicationConfiguration содержит @ComponentScan
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    AComponent aComponent = context.getBean(AComponent.class);
    System.out.println(aComponent);

    AService aService = context.getBean(AService.class);
    System.out.println(aService);
    BService bService = context.getBean(BService.class);
    System.out.println(bService);
  }
}

package demo01.after;

import demo01.after.configuration.ApplicationConfiguration;
import demo01.after.service.TransactionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    TransactionHandler handler = (TransactionHandler) context.getBean("transactionHandler");
//    TransactionHandler handler = (TransactionHandler) context.getBean(TransactionHandler.class);
    handler.handle();
  }
}

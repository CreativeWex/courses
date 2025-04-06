package demo00.after;

import demo00.after.configuration.ApplicationConfiguration;
import demo00.after.service.TransactionHandler;
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

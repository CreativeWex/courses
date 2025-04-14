package demo00.after.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo00.after.component.Serializer;
import demo00.after.service.ParamsGenerator;
import demo00.after.service.ParamsValidator;
import demo00.after.service.TransactionHandler;
import demo00.after.service.impl.DefaultTransactionHandler;
import demo00.after.component.OutputWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo00.after")
public class ApplicationConfiguration {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public TransactionHandler transactionHandler(ParamsGenerator paramsGenerator,
                                               ParamsValidator paramsValidator,
                                               Serializer serializer,
                                               OutputWriter outputWriter) {
    return new DefaultTransactionHandler(paramsGenerator, paramsValidator, serializer, outputWriter);
  }
}

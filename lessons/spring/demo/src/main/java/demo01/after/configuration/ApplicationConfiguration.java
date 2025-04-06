package demo01.after.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo01.after.component.Serializer;
import demo01.after.service.OutputWriter;
import demo01.after.service.ParamsGenerator;
import demo01.after.service.ParamsValidator;
import demo01.after.service.TransactionHandler;
import demo01.after.service.impl.DefaultParamsGenerator;
import demo01.after.service.impl.DefaultParamsValidator;
import demo01.after.service.impl.DefaultTransactionHandler;
import demo01.after.service.impl.SimpleOutputWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public ParamsGenerator paramsGenerator() {
    return new DefaultParamsGenerator();
  }

  @Bean
  public ParamsValidator paramsValidator() {
    return new DefaultParamsValidator();
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public Serializer serializer(ObjectMapper objectMapper) {
    return new Serializer(objectMapper);
  }

  @Bean
  public OutputWriter outputWriter() {
    return new SimpleOutputWriter();
  }

  @Bean
  public TransactionHandler transactionHandler(ParamsGenerator paramsGenerator,
                                               ParamsValidator paramsValidator,
                                               Serializer serializer,
                                               OutputWriter outputWriter) {
    return new DefaultTransactionHandler(paramsGenerator, paramsValidator, serializer, outputWriter);
  }
}

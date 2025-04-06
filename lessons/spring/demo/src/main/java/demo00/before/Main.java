package demo00.before;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo00.before.component.Serializer;
import demo00.before.service.OutputWriter;
import demo00.before.service.ParamsGenerator;
import demo00.before.service.ParamsValidator;
import demo00.before.service.TransactionHandler;
import demo00.before.service.impl.DefaultParamsGenerator;
import demo00.before.service.impl.DefaultParamsValidator;
import demo00.before.service.impl.DefaultTransactionHandler;
import demo00.before.service.impl.SimpleOutputWriter;

public class Main {
  public static void main(String[] args) {
    ParamsGenerator generator = new DefaultParamsGenerator();
    ParamsValidator validator = new DefaultParamsValidator();
    ObjectMapper mapper = new ObjectMapper();
    Serializer serializer = new Serializer(mapper);
    OutputWriter writer = new SimpleOutputWriter();

    TransactionHandler handler = new DefaultTransactionHandler(generator, validator, serializer, writer);
    handler.handle();
  }
}

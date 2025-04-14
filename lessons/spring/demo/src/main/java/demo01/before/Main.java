package demo01.before;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo01.before.component.Serializer;
import demo01.before.service.OutputWriter;
import demo01.before.service.ParamsGenerator;
import demo01.before.service.ParamsValidator;
import demo01.before.service.TransactionHandler;
import demo01.before.service.impl.SimpleOutputWriter;
import demo01.before.service.impl.DefaultParamsGenerator;
import demo01.before.service.impl.DefaultParamsValidator;
import demo01.before.service.impl.DefaultTransactionHandler;

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

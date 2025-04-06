package demo00.before.service.impl;

import demo00.before.component.Serializer;
import demo00.before.service.OutputWriter;
import demo00.before.service.ParamsGenerator;
import demo00.before.service.ParamsValidator;
import demo00.before.service.TransactionHandler;

import java.util.Map;

public class DefaultTransactionHandler implements TransactionHandler {
  private final ParamsGenerator generator;
  private final ParamsValidator validator;
  private final Serializer serializer;
  private final OutputWriter writer;

  public DefaultTransactionHandler(ParamsGenerator generator,
                                   ParamsValidator validator,
                                   Serializer serializer,
                                   OutputWriter writer) {
    this.generator = generator;
    this.validator = validator;
    this.serializer = serializer;
    this.writer = writer;
  }

  /**
   * Считываем параметры
   * Валидируем параметры
   * Сохраняем параметры
   */
  @Override
  public void handle() {
    Map<String, Object> inputParams = generator.generate();
    if (!validator.areParamsValid(inputParams)) {
      return;
    }
    String json = serializer.serialize(inputParams);
    writer.write(json);
  }
}

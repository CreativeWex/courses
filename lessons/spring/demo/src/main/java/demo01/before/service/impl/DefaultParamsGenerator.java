package demo01.before.service.impl;

import demo01.before.service.ParamsGenerator;

import java.util.Map;

public class DefaultParamsGenerator implements ParamsGenerator {

  @Override
  public Map<String, Object> generate() {
    return Map.of(
        "key 1", "102awda9381e203",
        "ratio", 10,
        "shouldBeUpdated", true
    );
  }
}

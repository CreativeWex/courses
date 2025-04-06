package demo00.after.service.impl;

import demo00.after.service.ParamsGenerator;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
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

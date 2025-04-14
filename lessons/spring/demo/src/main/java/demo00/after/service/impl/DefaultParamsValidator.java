package demo00.after.service.impl;

import demo00.after.service.ParamsValidator;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultParamsValidator implements ParamsValidator {

  @Override
  public boolean areParamsValid(Map<String, Object> inputParams) {
    return inputParams != null && !inputParams.isEmpty();
  }
}

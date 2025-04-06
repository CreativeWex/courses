package demo00.before.service.impl;

import demo00.before.service.ParamsValidator;

import java.util.Map;

public class DefaultParamsValidator implements ParamsValidator {

  @Override
  public boolean areParamsValid(Map<String, Object> inputParams) {
    return inputParams != null && !inputParams.isEmpty();
  }
}

package demo01.after.service.impl;

import demo01.after.service.ParamsValidator;

import java.util.Map;

public class DefaultParamsValidator implements ParamsValidator {

  @Override
  public boolean areParamsValid(Map<String, Object> inputParams) {
    return inputParams != null && !inputParams.isEmpty();
  }
}

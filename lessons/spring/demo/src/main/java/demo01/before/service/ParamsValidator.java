package demo01.before.service;

import java.util.Map;

public interface ParamsValidator {
  boolean areParamsValid(Map<String, Object> inputParams);
}

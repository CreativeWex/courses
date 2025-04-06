package demo00.before.service;

import java.util.Map;

public interface ParamsValidator {
  boolean areParamsValid(Map<String, Object> inputParams);
}

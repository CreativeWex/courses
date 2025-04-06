package demo01.after.service;

import java.util.Map;

public interface ParamsValidator {
  boolean areParamsValid(Map<String, Object> inputParams);
}

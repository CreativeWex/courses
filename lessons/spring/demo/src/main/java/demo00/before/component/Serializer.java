package demo00.before.component;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {
  private final ObjectMapper mapper;

  public Serializer(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public String serialize(Object o) {
    try {
      return mapper.writeValueAsString(o);
    } catch (Exception e) {
      System.out.println("Ошибка: " + e.getMessage());
      return "";
    }
  }
}

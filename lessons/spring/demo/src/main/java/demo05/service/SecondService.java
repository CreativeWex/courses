package demo05.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SecondService {
  private final ObjectMapper singletonMapper;
  private final ObjectMapper prototypeMapper;

  public SecondService(@Qualifier("singletonMapper") ObjectMapper singletonMapper,
                       @Qualifier("prototypeMapper") ObjectMapper prototypeMapper) {
    this.singletonMapper = singletonMapper;
    this.prototypeMapper = prototypeMapper;
  }

  public ObjectMapper getSingletonMapper() {
    return singletonMapper;
  }

  public ObjectMapper getPrototypeMapper() {
    return prototypeMapper;
  }
}

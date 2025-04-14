package demo03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColorService {
  @Autowired
  private String color;

  @Autowired
  public ColorService(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  @Autowired
  public void setColor(String color) {
    this.color = color;
  }
}

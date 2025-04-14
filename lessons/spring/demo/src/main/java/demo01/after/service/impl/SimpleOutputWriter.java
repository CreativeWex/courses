package demo01.after.service.impl;

import demo01.after.service.OutputWriter;

public class SimpleOutputWriter implements OutputWriter {

  @Override
  public void write(String message) {
    System.out.println("SimpleOutputWriter:" + message);
  }
}

package demo01.before.service.impl;

import demo01.before.service.OutputWriter;

public class SimpleOutputWriter implements OutputWriter {

  @Override
  public void write(String message) {
    System.out.println("SimpleOutputWriter:" + message);
  }
}

package demo00.after.component;

import org.springframework.stereotype.Component;

@Component
public class OutputWriter {

  public void write(String message) {
    System.out.println("SimpleOutputWriter:" + message);
  }
}

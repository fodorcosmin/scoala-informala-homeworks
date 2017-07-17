package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cosmin on 7/17/2017.
 */
public class MyLogger {


  private MyLogger() throws IOException {
    MyLogger.log(Level.INFO, MyLogger.class.getName()); // call log method using class name
  }

  private static Logger getLogger() {
    Logger logger = null;
    if (logger == null) {
      try {
        new MyLogger();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return logger;
  }

  public static void log(Level level, String msg) {
    getLogger().log(level, msg);
    System.out.println(msg);
  }
}

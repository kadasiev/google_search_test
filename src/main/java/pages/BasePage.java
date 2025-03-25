package pages;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  static {
    switch(System.getProperty("browser", "chrome")) {
      case "chrome" -> Configuration.browser = "chrome";
      case "firefox" ->  Configuration.browser = "firefox";
      default -> throw new IllegalArgumentException("Unsupported browser: "
          + System.getProperty("browser"));
    }
    Configuration.timeout = 30000;
  }
}

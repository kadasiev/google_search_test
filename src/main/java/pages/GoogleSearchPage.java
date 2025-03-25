package pages;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleSearchPage extends BasePage {

  private static final String SEARCH_FIELD = "//*[contains(@action,  'search')]//textarea";

  public void enterSearchQuery(String searchQuery) {
    $x(SEARCH_FIELD).setValue(searchQuery).pressEnter();
    logger.info("Search in Google for:{}", " \"" + searchQuery + "\"");
  }
}

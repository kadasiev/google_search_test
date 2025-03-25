package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage extends BasePage {

  private static final String SEARCH_RESULTS = "//a/h3";
  private static final String SEARCH_PAGES = "//tr[@jsname = 'TeSSVd']/td[not(@aria-level) and not(contains(@class, 'd6cvqb'))]";
  private static final String IMAGES_BUTTON = "//*[@role = 'listitem'][2]/a";
  private static final String IMAGES = "//*[contains(@data-attrid, 'images')]";
  private static final String IMAGE_PREVIEW_WINDOW = "//*[@id='Sva75c']";
  private static final String SEARCH_FIELD = "//*[@class = 'gLFyf']";
  private static final String SEARCH_BUTTON = "//button[@type = 'submit']";
  private static final String HELP_BUTTON = "//*[contains(@class, 'Fx4vi')][1]";
  private static final String SEND_FEED_BACK_BUTTON = "//*[contains(@class, 'Fx4vi')][2]";
  private static final String PRIVACY_BUTTON = "//*[contains(@class, 'Fx4vi')][3]";
  private static final String TERMS_BUTTON = "//*[contains(@class, 'Fx4vi')][4]";

  public void verifySearchResultsContainSubstring(String substring) {
    logger.info("Verification that search results contain the substring:{}", " \"" + substring + "\"");
    $$x(SEARCH_RESULTS).shouldHave(sizeGreaterThan(5))
        .filter(visible)
        .forEach(element -> element.shouldHave(text(substring)));
  }

  public SearchResultPage openSearchPageNumber(int number) {
    $$x(SEARCH_PAGES).shouldHave(sizeGreaterThan(4))
        .get(number - 1)
        .click();
    logger.info("Search page number{}opened", " \"" + number + "\" ");
    return this;
  }

  public SearchResultPage openImages() {
    $x(IMAGES_BUTTON).click();
    logger.info("Images opened");
    return this;
  }

  public void openImageNumber(int number) {
    $$x(IMAGES).shouldHave(sizeGreaterThan(50))
        .get(number - 1)
        .click();
    $x(IMAGE_PREVIEW_WINDOW).shouldBe(visible);
    logger.info("Image number{}opened for preview", " \"" + number + "\" ");
  }

  public void searchResultPageElements() {
    $x(SEARCH_FIELD).shouldBe(visible);
    $x(SEARCH_BUTTON).shouldBe(visible).shouldBe(clickable);
    $x(HELP_BUTTON).shouldBe(visible).shouldBe(clickable);
    $x(SEND_FEED_BACK_BUTTON).shouldBe(visible).shouldBe(clickable);
    $x(PRIVACY_BUTTON).shouldBe(visible).shouldBe(clickable);
    $x(TERMS_BUTTON).shouldBe(visible).shouldBe(clickable);
  }
}

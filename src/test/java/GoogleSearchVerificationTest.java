import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static util.TestDataReader.getValue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.GoogleSearchPage;
import pages.SearchResultPage;

public class GoogleSearchVerificationTest {

  GoogleSearchPage googleSearchPage = new GoogleSearchPage();
  SearchResultPage searchResultPage = new SearchResultPage();

  @Before
  public void setUp() {
    open(getValue("googleSearchPage"));
    googleSearchPage.enterSearchQuery("Java");
  }

  @Test
  public void verifySearchResult() {
    searchResultPage.verifySearchResultsContainSubstring("Java");
  }

  @Test
  public void verifyThatPaginationWorks() {
    searchResultPage.openSearchPageNumber(2)
        .verifySearchResultsContainSubstring("Java");
  }

  @Test
  public void verifyThatImageOpensInPreviewMode() {
    searchResultPage.openImages()
        .openImageNumber(1);
  }

  @Test
  public void verifySearchResultPage() {
    searchResultPage.searchResultPageElements();
  }

  @After
  public void tearDown() {
    closeWebDriver();
  }
}

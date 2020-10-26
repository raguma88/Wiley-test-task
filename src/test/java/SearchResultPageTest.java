import org.junit.Assert;
import org.junit.Test;

public class SearchResultPageTest extends TestBase {

    @Test  //Task 3.1 Part 1
    public void checkJavaWordInTitleExistsInEveryTitleTest() {
        popUp.closePopUpWindow();
        homePage.searchItem("java");
        homePage.clickSearchButton();
        Assert.assertTrue("Not every Titles contain 'Java' word",
                searchResultPage.checkJavaWordInTitles());
    }

    @Test //Task 3.2 Part 1
    public void checkSizeOfItems() {
        popUp.closePopUpWindow();
        homePage.searchItem("java");
        homePage.clickSearchButton();
        searchResultPage.getSizeOfItems();
        Assert.assertEquals(10, searchResultPage.getSizeOfItems());
    }

    @Test  //Task 3.3 Part 1 (doesn't work properly :( )
    public void checkElementsInItemSectionTest() {
        popUp.closePopUpWindow();
        homePage.searchItem("java");
        homePage.clickSearchButton();
        Assert.assertTrue(searchResultPage.checkElementsInItemSection());
    }
}

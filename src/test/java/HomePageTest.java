import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class HomePageTest extends TestBase {

    @Test  //Task 1.1 Part 1
    public void checkSizeOfListOfElementsForWhoWeServeButton() {
        popUp.closePopUpWindow();
        homePage.getSizeOfListOfElementsForWhoWeServeButton();
        Assert.assertEquals(12, homePage.getSizeOfListOfElementsForWhoWeServeButton());
    }

    @Test  //Task 1.2 Part 1
    public void checkElementsNamesForWhoWeServeButtonTest() {
        popUp.closePopUpWindow();
        List<String> expectedList = homePage.getExpectedElementsNamesForWhoWeServeButton();
        List<String> actualList = homePage.getActualElementsNamesForWhoWeServeButton();
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test  //Task 2 Part 1
    public void checkAreaUnderSearchFieldIsPresent() {
        popUp.closePopUpWindow();
        homePage.searchItem("java");
        boolean a = homePage.isAreaPresent();
        Assert.assertTrue(a);
    }
}

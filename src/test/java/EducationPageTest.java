import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class EducationPageTest extends TestBase {

    @Test  //Task 4.1 Part 1
    public void checkHeaderText() {
        popUp.closePopUpWindow();
        homePage.moveToSubjectsButton();
        homePage.moveToEducationPage();
        String header = educationPage.getHeaderText();
        Assert.assertEquals("Education", header);
    }

    @Test  //Task 4.2 Part 1
    public void checkSizeOfListAndElementsNamesInSubjectsSectionTest() {
        popUp.closePopUpWindow();
        homePage.moveToSubjectsButton();
        homePage.moveToEducationPage();
        educationPage.getSizeOfListOfElementsInSubjectsSection();
        Assert.assertEquals(13, educationPage.getSizeOfListOfElementsInSubjectsSection());
        List<String> expectedList = educationPage.getExpectedElementsNamesInSubjectsSection();
        List<String> actualList = educationPage.getActualElementsNamesInSubjectsSection();
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }
}


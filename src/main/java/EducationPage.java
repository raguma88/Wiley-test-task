import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EducationPage {

    public WebDriver driver;
    public EducationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerText = By.xpath("//span[text()='Education']");
    private By listOfElementsInSubjectsSection = By.xpath("//div[@class='side-panel']//ul/li/a");

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    public int getSizeOfListOfElementsInSubjectsSection() {
        return driver.findElements(listOfElementsInSubjectsSection).size();
    }

    public List<String> getActualElementsNamesInSubjectsSection() {
        List<WebElement> webElements = driver.findElements(listOfElementsInSubjectsSection);
        List<String> elementNames = new ArrayList<>();
        for(WebElement cell : webElements) {
            elementNames.add(cell.getAttribute("innerText"));
        }
        return elementNames;
    }

    public List<String> getExpectedElementsNamesInSubjectsSection() {
        String[] elementsNames = new String[] {
                "Information & Library Science",
                "Education & Public Policy",
                "K-12 General",
                "Higher Education General",
                "Vocational Technology",
                "Conflict Resolution & Mediation (School settings)",
                "Curriculum Tools- General",
                "Special Educational Needs",
                "Theory of Education",
                "Education Special Topics",
                "Educational Research & Statistics",
                "Literacy & Reading",
                "Classroom Management",};
        return Arrays.asList(elementsNames);
    }
}

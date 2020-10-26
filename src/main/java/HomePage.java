import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    public WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private By whoWeServeButton = By.xpath("//ul[@class='navigation-menu-items initialized']/li[1]/a");
    private By subjectsButton = By.xpath("//ul[@class='navigation-menu-items initialized']/li[2]/a");
    private By educationButton = By.xpath("//div[@id='Level1NavNode2']/ul/li[9]/a");
    private By searchField = By.xpath("//input[@id='js-site-search-input']");
    private By areaUnderSearchField = By.xpath("//aside[@id='ui-id-2']");
    private By searchButton = By.xpath("//span/button[text()='Search']");
    private By listOfElementsForWhoWeServeButton = By.xpath("//*[@id='Level1NavNode1']/ul/li[*]/a");


    public HomePage clickWhoWeServeButton() {
        driver.findElement(whoWeServeButton).click();
            return this;
        }


    public int getSizeOfListOfElementsForWhoWeServeButton() {
        return driver.findElements(listOfElementsForWhoWeServeButton).size();
    }

    public HomePage searchItem(String itemName) {
        WebElement searchInput = driver.findElement(searchField);
        searchInput.sendKeys(itemName);
        return this;
    }

    public boolean isAreaPresent() {
        return driver.findElements(areaUnderSearchField).size() > 0;
    }

    public SearchResultPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    public List<String> getActualElementsNamesForWhoWeServeButton() {
        clickWhoWeServeButton();
        List<WebElement> webElements = driver.findElements(listOfElementsForWhoWeServeButton);
        List<String> elementNames = new ArrayList<>();

        for(WebElement cell : webElements) {
            elementNames.add(cell.getAttribute("innerText"));
        }
        return elementNames;
    }

    public List<String> getExpectedElementsNamesForWhoWeServeButton() {
        String[] elementsNames = new String[] {
                "Students",
                "Instructors",
                "Book Authors",
                "Professionals",
                "Researchers",
                "Institutions",
                "Librarians",
                "Corporations",
                "Societies",
                "Journal Editors",
                "Bookstores",
                "Government"};
        return Arrays.asList(elementsNames);
    }

    public HomePage moveToSubjectsButton() {
        Actions actions = new Actions(driver);
        WebElement subjectButton = driver.findElement(subjectsButton);
        actions.moveToElement(subjectButton).click().perform();
        return this;
    }

    public EducationPage moveToEducationPage() {
        driver.findElement(educationButton).click();
        return new EducationPage(driver);
    }
}



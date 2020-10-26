import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    public WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemTitle = By.xpath("//div[@class='products-list']/section/div/h3/a");
    private By itemSection = By.xpath("//section[@class='product-item']");
    private By printTagInItemSection = By.xpath("//section//div[text()='Print']");
    private By ebookTagInItemSection = By.xpath("//section//div[text()='E-Book']");
    private By obookTagInItemSection = By.xpath("//section//div[text()='O-Book']");
    private By addToCartButtonInItemSection = By.xpath("//section//button[text()='Add to cart']");
    private By viewOnWileyButton = By.xpath
            ("//section//div[@class='product-button']/a[@class='small-button learn-more-button']");


    public int getSizeOfItems() {
        return driver.findElements(itemTitle).size();
    }

    public boolean checkJavaWordInTitles() {
        boolean checkTitle = false;
        List<WebElement> webElements = driver.findElements(itemTitle);
        List<String> elementNames = new ArrayList<>();
        for (WebElement cell : webElements) {
            elementNames.add(cell.getAttribute("innerText"));
        }

        for (String e : elementNames) {
            if(e.contains("java") || e.contains("Java")) {
                checkTitle = true;
            }
        }
        return checkTitle;
    }

    public boolean checkElementsInItemSection() {
        boolean elements = false;
        List<WebElement> webElements = driver.findElements(itemSection);
        for (WebElement cell : webElements) {

            if (cell.findElement(ebookTagInItemSection).isDisplayed() &&
                    cell.findElement(ebookTagInItemSection).isEnabled()){
                if (cell.findElement(addToCartButtonInItemSection).isDisplayed()) {
                    elements = true;
                } else
                    return false;
            }

            if (cell.findElement(printTagInItemSection).isDisplayed() &&
                    cell.findElement(printTagInItemSection).isEnabled()){
                if (cell.findElement(addToCartButtonInItemSection).isDisplayed()) {
                    elements = true;
                } else
                    return false;
            }
                if (!cell.findElement(printTagInItemSection).isEnabled()) {
                    cell.findElement(printTagInItemSection).click();
                    if (cell.findElement(addToCartButtonInItemSection).isDisplayed()) {
                        elements = true;
                    } else
                        return false;
                }

            if (cell.findElement(obookTagInItemSection).isDisplayed() &&
                    cell.findElement(obookTagInItemSection).isEnabled()){
                if (cell.findElement(viewOnWileyButton).isDisplayed()) {
                    elements = true;
                } else
                    return false;
            }

            if (!cell.findElement(obookTagInItemSection).isEnabled()) {
                cell.findElement(obookTagInItemSection).click();
                if (cell.findElement(viewOnWileyButton).isDisplayed()) {
                    elements = true;
                } else
                    return false;
            }
        }
        return elements;
    }

}

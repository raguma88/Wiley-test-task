import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpWindowsManager {

    public WebDriver driver;
    public PopUpWindowsManager(WebDriver driver) {
        this.driver = driver;
    }

    private By popUpWindowTitle = By.xpath("//div[text()='Undetected location']");
    private By closePopUpWindowButton = By.xpath("//button[@aria-label=\"Close\"]");

    public PopUpWindowsManager closePopUpWindow() {
        if (driver.findElements(popUpWindowTitle).size() > 0) {
            driver.findElement(closePopUpWindowButton).click();
        }
        return this;
    }
}

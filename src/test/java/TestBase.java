import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public HomePage homePage;
    public PopUpWindowsManager popUp;
    public SearchResultPage searchResultPage;
    public EducationPage educationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "/home/ralfidze/Documents/Gulnara/Intellij/drivers/geckodriver");
        //System.setProperty("webdriver.chrome.driver",
        // "/home/ralfidze/Documents/Gulnara/Intellij/drivers/chromedriver");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wiley.com/en-us");
        homePage = new HomePage(driver);
        popUp = new PopUpWindowsManager(driver);
        searchResultPage = new SearchResultPage(driver);
        educationPage = new EducationPage(driver);
    }

        @After
        public void tearDown() {
        driver.quit();
    }
}

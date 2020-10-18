import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    protected static MainPage mainPage;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Маргарита Житкевич\\IdeaProjects\\AmazonTest\\drivers\\chromedriver.exe");
//        System.setProperty("webdriver.firefox.driver", "C:\\Users\\Маргарита Житкевич\\IdeaProjects\\AmazonTest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

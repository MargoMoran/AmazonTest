package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    private static ThreadLocal<WebDriver> WEBDRIVER = new ThreadLocal<WebDriver>();

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.firefox.driver", "C:\\Users\\Маргарита Житкевич\\IdeaProjects\\AmazonTest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WEBDRIVER.set(driver);
        driver.get("https://www.amazon.com/");
    }

    public static WebDriver getDriver() {
        return WEBDRIVER.get();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

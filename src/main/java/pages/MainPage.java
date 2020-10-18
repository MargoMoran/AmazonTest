package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By navBarAccountTab = By.xpath("//span[@class='nav-line-2 nav-long-width']");
    private By startHereButton = By.id("nav-flyout-ya-newCust");
    private By searchField = By.id("twotabsearchtextbox");
    private By searchButton = By.cssSelector("#nav-search-submit-text > input:nth-child(1)");

    public SignInPage clickOnNavBar() {
        driver.findElement(navBarAccountTab).click();
        return new SignInPage(driver);
    }

    public SearchPage searchAndSubmit(String searchValue) {
        driver.findElement(searchField).sendKeys(searchValue);
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }



}

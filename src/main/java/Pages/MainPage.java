package Pages;

import Base.BasePage;
import Data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    By navBarAccountTab = By.xpath("//span[@class='nav-line-2 nav-long-width']");
    By startHereButton = By.id("nav-flyout-ya-newCust");
    By searchField = By.id("twotabsearchtextbox");
    By searchButton = By.cssSelector("#nav-search-submit-text > input:nth-child(1)");

    String urlString = "https://www.amazon.com/";

    public MainPage getPage() {
        getURL(urlString);
        return this;
    }

    public void clickOnNavBar() {
        clickOnElement(navBarAccountTab, 10);
    }

    public void searchAndSubmit(Constants.SearchValue VALUE1) {
        putStringToField(searchField, VALUE1.getValue());
        clickOnElement(searchButton, 5);
    }


}

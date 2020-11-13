package Base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Base.BaseTest.getDriver;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = getDriver();
    }

    public void getURL(String urlString) {
        driver.get(urlString);
    }

    public void waitVisibilityOfElement(By element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitVisibilityOfElement(WebElement element, int waitTime) throws NullPointerException {
        WebDriverWait wait = (new WebDriverWait(driver, waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element, int waitTime) throws TimeoutException {
        waitVisibilityOfElement(element, waitTime);
        element.click();
    }

    public void clickOnElement(By element, int waitTime) throws TimeoutException {
        waitVisibilityOfElement(element, waitTime);
        driver.findElement(element).click();
    }
    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void putStringToField(By element, String string) throws TimeoutException {
        driver.findElement(element).click();
        driver.findElement(element).sendKeys(string);
    }
    public void putStringToField(By element, String string, int waitTime) throws TimeoutException {
        waitVisibilityOfElement(element, waitTime);
        driver.findElement(element).click();
        driver.findElement(element).sendKeys(string);
    }

    public List<WebElement> getElementList(By locatorOfList) {
        return driver.findElements(locatorOfList);
    }

    public String getOnlyTextOfElement (WebElement element){
        return element.getText().replaceAll("[$A-Za-z,]", "");
    }

    public void verifyThatHeaderIsCorrect(By locatorOfHeader, String expectedText){
        String headerText = driver.findElement(locatorOfHeader).getText();
        Assert.assertEquals(headerText, expectedText);
    }

    public void verifyThatElementIsCorrect(By locatorOfElement, String expectedText){
        String elementText = driver.findElement(locatorOfElement).getText();
        Assert.assertEquals(expectedText, elementText);
    }
    public void verifyThatTextIsCorrect(String expectedText, By locatorOfElement){
        String elementText = driver.findElement(locatorOfElement).getText().replaceAll("\"","");
        Assert.assertEquals(expectedText, elementText);
    }

    public void verifyThatElementIsPresent(By locatorOfElement){
        WebElement element = driver.findElement(locatorOfElement);
        Assert.assertTrue(element.isDisplayed());
    }

    public String getPageHeaderText(By locatorOfHeader) {
        return driver.findElement(locatorOfHeader).getText();
    }
}

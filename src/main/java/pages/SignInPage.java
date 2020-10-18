package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Values.Constans.SignUpValues.USER2;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    private By emailField = By.xpath("//input[@id='ap_email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By signInPageHeader = By.xpath("//h1[contains(text(),'Sign-In')]");
    private By continueButton = By.xpath("//input[@id='continue']");
    private By signInSubmitButton = By.xpath("//input[@id='signInSubmit']");
    private By createAccountSubmitButton = By.id("createAccountSubmit");

    public String getSignInPageHeaderText() {
        return driver.findElement(signInPageHeader).getText();
    }

    public SignUpPage tapCreateAnAccButton() {
        driver.findElement(createAccountSubmitButton).click();
        return new SignUpPage(driver);
    }

    public SignInPage enterLoginAndNext() {
        driver.findElement(emailField).sendKeys(USER2.getEmail());
        driver.findElement(continueButton).click();
        return this;
    }
    public SignInPage enterPasswordAndNext() {
        driver.findElement(passwordField).sendKeys(USER2.getPassword());
        driver.findElement(signInSubmitButton).click();
        return this;
    }


}

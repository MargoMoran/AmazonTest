package Pages;

import Base.BasePage;
import Data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.xpath("//input[@id='ap_email']");
    By passwordField = By.xpath("//input[@type='password']");
    By signInPageHeader = By.xpath("//h1[contains(text(),'Sign-In')]");
    By continueButton = By.xpath("//input[@id='continue']");
    By signInSubmitButton = By.xpath("//input[@id='signInSubmit']");
    By createAccountSubmitButton = By.id("createAccountSubmit");
    By emailFieldAsText = By.xpath("//span[contains(text(),'@')]");
    By alertMessage = By.xpath("//*[@class='a-alert-heading']");
    By amazonLogo = By.xpath("//*[@class=\"a-icon a-icon-logo\"]");
    By mainLogo = By.id("nav-logo");

    int waitTime = 5;

    public SignInPage signInFlow(Constants.SignUpValues USER2) {
        verifyThatHeaderIsCorrect(signInPageHeader, "Sign-In");
        putStringToField(emailField, USER2.getEmail(), waitTime);
        clickOnElement(continueButton);
        verifyThatElementIsCorrect(emailFieldAsText, USER2.getEmail());
        putStringToField(passwordField, USER2.getPassword(), waitTime);
        clickOnElement(signInSubmitButton);
        waitVisibilityOfElement(alertMessage,waitTime);
        verifyThatElementIsCorrect(alertMessage, "Important Message!");
        return new SignInPage(driver);
    }

    public SignUpPage tapCreateAnAccButton() {
        clickOnElement(createAccountSubmitButton, 10);
        return new SignUpPage(driver);
    }

    public MainPage returnToMainPage(){
        clickOnElement(amazonLogo);
        verifyThatElementIsPresent(mainLogo);
        return new MainPage(driver);
    }

}

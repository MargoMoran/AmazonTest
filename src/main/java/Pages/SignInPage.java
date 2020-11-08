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

    public void signInFlow(Constants.SignUpValues USER2) {
        verifyThatHeaderIsCorrect(signInPageHeader, "Sign-In");
        putStringToField(emailField, USER2.getEmail());
        clickOnElement(continueButton);
        putStringToField(passwordField, USER2.getPassword());
        clickOnElement(signInSubmitButton);
    }

    public void tapCreateAnAccButton() {
        clickOnElement(createAccountSubmitButton, 10);
    }

}

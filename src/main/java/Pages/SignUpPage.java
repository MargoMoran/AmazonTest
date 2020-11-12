package Pages;

import Base.BasePage;
import Data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private By signUpPageHeader = By.xpath("//h1[@class=\"a-spacing-small\"]");
    private By loginField = By.id("ap_customer_name");
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By checkPasswordField = By.id("ap_password_check");
    private By createAccButton = By.id("continue");

    int waitTime = 5;

    public void register(Constants.SignUpValues USER) {
        verifyThatHeaderIsCorrect(signUpPageHeader, "Create account");
        putStringToField(loginField, USER.getUserName(), waitTime);
        putStringToField(emailField, USER.getEmail());
        putStringToField(passwordField, USER.getPassword());
        putStringToField(checkPasswordField, USER.getPassword());
        clickOnElement(createAccButton);
    }
}

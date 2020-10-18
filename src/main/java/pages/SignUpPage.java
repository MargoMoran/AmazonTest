package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signUpPageHeader = By.xpath("//h1[@class=\"a-spacing-small\"]");
    private By loginField = By.id("ap_customer_name");
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By checkPasswordField = By.id("ap_password_check");
    private By createAccButton = By.id("continue");

    public SignUpPage typeUserName(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }
    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignUpPage typePasswordChecked(String password) {
        driver.findElement(checkPasswordField).sendKeys(password);
        return this;
    }
    public SignUpPage createAnAcc() {
        driver.findElement(createAccButton).click();
        return new SignUpPage(driver);
    }
    public String getSignUpPageHeaderText() {
        return driver.findElement(signUpPageHeader).getText();
    }

    public void register(Values.Constans.SignUpValues USER) {
        this.typeUserName(USER.getUserName());
        this.typeEmail(USER.getEmail());
        this.typePassword(USER.getPassword());
        this.typePasswordChecked(USER.getPassword());
        this.createAnAcc();
    }
}

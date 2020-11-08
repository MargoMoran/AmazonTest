import Base.BaseTest;
import Data.Constants;
import Pages.MainPage;
import Pages.SearchPage;
import Pages.SignInPage;
import Pages.SignUpPage;
import org.junit.Test;

import static Data.Constants.SearchValue.VALUE1;

public class Tests extends BaseTest {

    @Test
    public void logInWithValidCredsTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnNavBar();
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signInFlow(Constants.SignUpValues.USER2);
    }

    @Test
    public void signUpWithExistingUserTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnNavBar();
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.tapCreateAnAccButton();
        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.register(Constants.SignUpValues.USER);
    }

    @Test
    public void fullSearchResultsTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.searchAndSubmit(VALUE1);
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.getPricesList();
        searchPage.getPricesListUnderNumber(40);
        searchPage.getSumPrices(40);
    }

}

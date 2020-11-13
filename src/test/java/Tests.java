import Base.BaseTest;
import Data.Constants;
import Pages.MainPage;
import Pages.SearchPage;
import Pages.SignInPage;
import org.junit.Test;

import static Data.Constants.SearchValue.*;
import static Data.Constants.SignUpValues.USER3;


public class Tests extends BaseTest {

    @Test
    public void logInWithValidCredsTest() {
        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickOnNavBar()
                .signInFlow(USER3);
    }

    @Test
    public void signUpWithExistingUserTest() {
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = new SignInPage(getDriver());

        mainPage.clickOnNavBar()
                .tapCreateAnAccButton()
                .register(Constants.SignUpValues.USER1);
    }

    @Test
    public void fullSearchResultsTest() {
        MainPage mainPage = new MainPage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        mainPage.searchAndSubmit(VALUE1);
        searchPage.getPricesList();
        searchPage.getPricesListUnderNumber(VALUE_OF_NUMBER);
        searchPage.getSumPrices(VALUE_OF_NUMBER);
    }

    @Test
    public void fullSignInAndSearchFlow() {
        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickOnNavBar()
                .signInFlow(USER3)
                .returnToMainPage()
                .searchAndSubmit(VALUE2)
                .getPricesList();
    }

}

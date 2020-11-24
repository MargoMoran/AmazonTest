import Base.BaseTest;
import Data.Constants;
import Pages.MainPage;
import Pages.SearchPage;
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

        mainPage.clickOnNavBar()
                .tapCreateAnAccButton()
                .register(Constants.SignUpValues.USER1);
    }

    @Test
    public void fullSearchResultsTest() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        mainPage.searchAndSubmit(VALUE2);
        searchPage.getPricesList(VALUE2);
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
                .getPricesList(VALUE2);
    }

    @Test
    public void checkAllCheckboxes() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());

        mainPage.searchAndSubmit(VALUE3)
                .checkManyCheckboxes()
                .clearFilter()
                .checkSingeCheckboxes();

    }
}

import Values.Constans;
import org.junit.Assert;
import org.junit.Test;
import pages.SearchPage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {
    @Test
    public void testSignUpWithExistingEmail() {
        SignInPage signInPage = mainPage.clickOnNavBar();
        String signInPageHeader = signInPage.getSignInPageHeaderText();
        Assert.assertEquals("Sign-In", signInPageHeader);
        SignUpPage signUpPage = signInPage.tapCreateAnAccButton();
        String signUpPageHeader = signUpPage.getSignUpPageHeaderText();
        Assert.assertEquals("Create account", signUpPageHeader);
        signUpPage.register(Constans.SignUpValues.USER);
    }

    @Test
    public void logInWithValidCredsTest() {
        SignInPage signInPage = mainPage.clickOnNavBar();
        signInPage.enterLoginAndNext();
        signInPage.enterPasswordAndNext();
    }

    @Test
    public void searchAndSubmitTest() {
        mainPage.searchAndSubmit("xiaomi mi 5");
    }

    @Test
    public void getListTest() {
        SearchPage searchPage = mainPage.searchAndSubmit("xiaomi mi 5");
        System.out.println(searchPage.getPrices());
    }

    @Test
    public void getLowPriceListTest() {
        SearchPage searchPage = mainPage.searchAndSubmit("asus rog zephyrus");
        System.out.println(searchPage.getPrices2());
    }
    @Test
    public void sumTest() {
        SearchPage searchPage = mainPage.searchAndSubmit("xiaomi mi 5");
        System.out.println(searchPage.getSumPrices());
    }

}

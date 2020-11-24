package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Data.Constants.SearchValue;

public class SearchPage extends BasePage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By pricesLocator = By.xpath("//span[@class=\"a-price-whole\"]");
    private By spanWithResultsFor = By.xpath("//*[@class=\"a-color-state a-text-bold\"]");
    private By listOfBrandsCheckboxes = By.xpath("//li[contains(@id,'p_89')]//i");
    private By listOfFeaturesCheckboxes = By.xpath("//li[contains(@id,'p_n_feature_eleven_browse-bin')]");
    private By listOfOperatingSystemCheckboxes = By.xpath("//li[contains(@id,'p_n_feature_twenty')]//i");
    private By checkbox = By.xpath("//li[contains(@id,'p_n_feature_fifteen_browse-bin')]");
    private By listOfPhoneCarrier = By.xpath("//*[contains(@id,'p_n_feature_ten_browse-bin')]//input");
    private By listOfSellers = By.xpath("//*[contains(@aria-labelledby,'p_6-title')]//input");
    private By firstBrandCheckbox = By.xpath("//li[contains(@id,'p_89')][1]//i");
    private By secondBrandCheckbox = By.xpath("//li[contains(@id,'p_89')][2]//i");
    private By firstOperatingSystemCheckbox = By.xpath("//li[contains(@id,'p_n_feature_twenty')][1]//i");
    private By listOperatingSystemCheckbox = By.xpath("//li[contains(@id,'p_n_feature_twenty')][1]//i");
    private By searchSubmitButton = By.xpath("//*[@id=\"nav-search-submit-text\"]/input");
    private By stars4Review = By.xpath("//*[contains(@aria-label,'4 Stars')]");
    private By stars3Review = By.xpath("//*[contains(@aria-label,'3 Stars')]");
    private By stars2Review = By.xpath("//*[contains(@aria-label,'2 Stars')]");
    private By stars1Review = By.xpath("//*[contains(@aria-label,'1 Star')]");
    private By minPriceValue = By.id("low-price");
    private By maxPriceValue = By.id("high-price");
    private By clearFilterButton = By.xpath("//*[@id=\"n\"]//span[2]");


    public SearchPage getPricesList(SearchValue x) {
        List<WebElement> prices = getElementList(pricesLocator);
        List<String> q = prices.stream().map(WebElement::getText).collect(Collectors.toList());
        verifyThatTextIsCorrect(x.getValue(), spanWithResultsFor);
        return new SearchPage(driver);
    }

    public List<Integer> getPricesListUnderNumber(SearchValue VALUE_OF_NUMBER) {
        List<Integer> pricesListInt = new ArrayList<>();
        List<WebElement> pricesList = getElementList(pricesLocator);
        for (WebElement s : pricesList) {
            int price = Integer.parseInt(getOnlyTextOfElement(s));
            if (price < VALUE_OF_NUMBER.hashCode()) {
                pricesListInt.add(price);
            }
        }
        return pricesListInt;
    }

    public int getSumPrices(SearchValue VALUE_OF_NUMBER) {
        return getPricesListUnderNumber(VALUE_OF_NUMBER).stream().reduce(0, Integer::sum);
    }

    public SearchPage checkManyCheckboxes() {
        clickOnElement(stars4Review);
        checkAllCheckboxesInBlock(listOfBrandsCheckboxes);
        putStringToField(maxPriceValue, "100", 20);
        putStringToField(minPriceValue, "40", 20);
        enterClick();
        moveToElement(listOfPhoneCarrier);
        checkNumberOfCheckboxes(listOfOperatingSystemCheckboxes, 1);
        checkNumberOfCheckboxes(listOfFeaturesCheckboxes, 1);
        return new SearchPage(driver);
    }

    public SearchPage checkSingeCheckboxes() {
        clickOnElement(stars3Review);
        checkOneCheckbox(secondBrandCheckbox);
        moveToElement(listOfFeaturesCheckboxes);
        checkOneCheckbox(firstOperatingSystemCheckbox);
        checkOneCheckbox(firstBrandCheckbox);
        return new SearchPage(driver);
    }

    public SearchPage clearFilter() throws InterruptedException {
        waitVisibilityOfElement(clearFilterButton,30);
        clickOnElement(clearFilterButton,20);
        Thread.sleep(2000);
        return new SearchPage(driver);
    }


}
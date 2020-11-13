package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Data.Constants.SearchValue;
import static Data.Constants.SearchValue.VALUE2;

public class SearchPage extends BasePage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By pricesLocator = By.xpath("//span[@class=\"a-price-whole\"]");
    private By spanWithResultsFor = By.xpath("//*[@class=\"a-color-state a-text-bold\"]");

    public SearchPage getPricesList() {
        List<WebElement> prices = getElementList(pricesLocator);
        List<String> q = prices.stream().map(WebElement::getText).collect(Collectors.toList());
        verifyThatTextIsCorrect(VALUE2.getValue(), spanWithResultsFor);
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

}
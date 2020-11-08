package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By pricesLocator = By.xpath("//span[@class=\"a-price-whole\"]");

    public List<String> getPricesList() {
        List<WebElement> prices = getElementList(pricesLocator);
        return prices.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Integer> getPricesListUnderNumber(int number) {
        List<Integer> pricesListInt = new ArrayList<>();
        List<WebElement> pricesList = getElementList(pricesLocator);
        for (WebElement s : pricesList) {
            int price = Integer.parseInt(getOnlyTextOfElement(s));
            if (price < number) {
                pricesListInt.add(price);
            }
        }
        return pricesListInt;
    }

    public int getSumPrices(int number) {
        return getPricesListUnderNumber(number).stream().reduce(0, Integer::sum);
    }
}
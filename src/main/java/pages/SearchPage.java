package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By pricesLocator = By.xpath("//span[@class=\"a-price-whole\"]");

    public List<String> getPrices() {
        List<WebElement> prices = driver.findElements(pricesLocator);
        return prices.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public List<Integer> getPrices2() {
        List<Integer> pricesListInt = new ArrayList<>();
        List<WebElement> pricesList = driver.findElements(pricesLocator);
        for (WebElement s : pricesList) {
            String priceString = s.getText().replaceAll( "[$A-Za-z,]", "");
            int price = Integer.parseInt(priceString);
            if (price < 1600) {
                pricesListInt.add(price);
            }
        }
        return pricesListInt;
    }

    public int getSumPrices() {
        int sum = getPrices2().stream().reduce(0,Integer::sum);
        return sum;
    }
}
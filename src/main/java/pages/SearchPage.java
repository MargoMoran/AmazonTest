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
        List<Integer> price = new ArrayList<>();
        List<String> stringList = getPrices();
        for (String s : stringList) {
            int prices = Integer.parseInt(s);
            if (prices < 40) {
                price.add(prices);
            }
        }
        return price;
    }

    public int getSumPrices() {
        int sum = getPrices2().stream().reduce(0,Integer::sum);
        return sum;
    }
}
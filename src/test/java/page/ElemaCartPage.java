package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import org.openqa.selenium.support.FindBy;

public class ElemaCartPage extends AbstractPage {

    @FindBy(xpath = "//input[@class=\"basket-item-amount-filed\"]")
    WebElement cartItem;

    public ElemaCartPage(WebDriver driver) {
        super(driver);
    }

    public String getCountOfItems(){
        return cartItem.getAttribute("value");
    }

}

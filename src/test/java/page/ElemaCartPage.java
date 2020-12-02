package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import org.openqa.selenium.support.FindBy;

public class ElemaCartPage extends AbstractPage {
    @FindBy(xpath = "//table[@class=\"basket-items-list-table\"]")
    WebElement countOfItem;

    public ElemaCartPage(WebDriver driver) {
        super(driver);
    }

    public int getCountOfItems(){
        ArrayList<WebElement> cartItems = new ArrayList<WebElement>();
        cartItems.add(countOfItem);
        return cartItems.size();
    }
}

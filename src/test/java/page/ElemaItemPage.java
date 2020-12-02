package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElemaItemPage extends AbstractPage{
    @FindBy(xpath = "//li[@title=\"44\"]")
    WebElement targetSize;

    @FindBy(xpath = "//li[@title=\"170\"]")
    WebElement targetHeight;

    @FindBy(xpath = "//a[@href=\"javascript:void(0);\"]")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@href=\"/personal/cart/\"]")
    WebElement openCartButton;

    public ElemaItemPage(WebDriver driver) {
        super(driver);
    }

    public ElemaItemPage chooseSize(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        targetSize))
                .click();
        return this;
    }

    public ElemaItemPage chooseHeight(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(
                        targetHeight))
                .click();
        return this;
    }

    public ElemaItemPage addToCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton))
                .click();
        return this;
    }

    public ElemaItemPage scrollToItem(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",targetSize);
        return this;
    }

    public ElemaCartPage openCart(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(openCartButton))
                .click();
        return new ElemaCartPage(driver);
    }

}

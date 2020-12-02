package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElemaHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://elema.by/";
    private static String productNumber = "0С360-20-Р53";

    @FindBy(xpath = "//*[@id=\"main-nav\"]/div/form/div/input")
    private WebElement searchInput;

    public ElemaHomePage(WebDriver driver) {
        super(driver);
    }

    public ElemaHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public ElemaProductContainerPage inputProductNumber() {
        searchInput.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(productNumber);
        searchInput.sendKeys(Keys.ENTER);
        return new ElemaProductContainerPage(driver);
    }
}

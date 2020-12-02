package test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ElemaHomePage;
import page.ElemaProductContainerPage;
import page.ElemaItemPage;
import page.ElemaCartPage;

public class ElemaPOTests {

    private WebDriver driver;
    private ChromeOptions options;

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1600,900");
        driver = new ChromeDriver(options);
    }

    @Test
    public void addItemToCartTest(){
        String countOfItems = new ElemaHomePage(driver)
                .openPage()
                .inputProductNumber()
                .chooseTargetModel()
                .scrollToItem()
                .chooseSize()
                .chooseHeight()
                .addToCart()
                .openCart()
                .getCountOfItems();

        Assert.assertEquals(countOfItems, "1");
    }

    @Test
    public void addThreeItemsToCartTest(){
        String countOfItems = new ElemaHomePage(driver)
                .openPage()
                .inputProductNumber()
                .chooseTargetModel()
                .scrollToItem()
                .chooseSize()
                .chooseHeight()
                .addToCart()
                .addToCart()
                .addToCart()
                .openCart()
                .getCountOfItems();

        Assert.assertEquals(countOfItems, "3");
    }

    @AfterMethod
    public void closeDriver(){
       driver.close();
    }
}

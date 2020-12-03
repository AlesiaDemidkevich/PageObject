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
    private static String productNumber = "0С360-20-Р53";

    @BeforeMethod(alwaysRun = true)
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1600,900");
        driver = new ChromeDriver(options);
    }

    @Test
    public void addItemToCartTest(){
        String countOfItems = new ElemaHomePage(driver)
                .openPage()
                .inputProductNumber(productNumber)
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
                .inputProductNumber(productNumber)
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

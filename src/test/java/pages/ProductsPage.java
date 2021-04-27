package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final By PRODUCT_LABLE = By.cssSelector(".title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage buyProduct (String productName){
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return this;
    }

//    public void isPageOpened1() {
//        try {
//            driver.findElement(PRODUCT_LABLE);
//        } catch (NoSuchElementException ex) {
//            Assert.fail("Страница продукта не была загружена");
//        }

    public void isPageOpened2() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABLE));
        } catch (TimeoutException ex) {
            Assert.fail("Страница продукта не была загружена");
        }
    }
}

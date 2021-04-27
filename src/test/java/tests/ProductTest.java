package tests;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest {


    @Test (retryAnalyzer = Retry.class)
    public void productsShouldBeAvailableInCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
    }
}

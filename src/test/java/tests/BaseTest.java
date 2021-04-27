package tests;

import org.testng.ITestContext;
import pages.*;
import tests.CapabilitiesGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup(ITestContext iTestContext, ITestResult testResult) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        iTestContext.setAttribute("driver",driver);
        //       testResult.getTestContext().setAttribute("driver", browser);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

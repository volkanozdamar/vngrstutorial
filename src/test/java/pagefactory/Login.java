package pagefactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;
    LoginFactory loginFactory;
    StoreFactory storeFactory;

    @BeforeSuite
    void init(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeTest
    void SetUp(){
        driver = new EdgeDriver();
        loginFactory = new LoginFactory(driver);
        storeFactory = new StoreFactory(driver);
    }
    @Test
    void LoginTest(){
        driver.get("https://www.saucedemo.com/");
        loginFactory.fillLoginForm("standard_user","secret_sauce");
        storeFactory.getStoreHeaderText();
        Assert.assertEquals(storeFactory.getStoreHeaderText(),"PRODUCTS");
    }

    @Test
    void LoginFailureTest(){
        driver.get("https://www.saucedemo.com/");
        loginFactory.fillLoginForm("standard_user","*****");
        Assert.assertEquals(loginFactory.getErrorText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterTest
    void TearDown(){
        driver.quit();
    }
}

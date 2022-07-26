package pageobject;

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
    LoginPage loginPage;
    StorePage storePage;
    @BeforeSuite
    void init(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeTest
    void SetUp(){
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        storePage = new StorePage(driver);

    }
    @Test
    void LoginTest(){
        driver.get("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user","secret_sauce");
        Assert.assertEquals(storePage.getStoreHeaderText(),"PRODUCTS");
    }


    @Test
    void LoginFailureTest(){
        driver.get("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user","*****");
        Assert.assertEquals(loginPage.getErrorText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterTest
    void TearDown(){
        driver.quit();
    }
}

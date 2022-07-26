import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login {
    WebDriver driver;

    @BeforeSuite
    void init(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeTest
    void SetUp(){
        driver = new EdgeDriver();
    }
    @Test
    void LoginTest(){
        driver.get("https://www.saucedemo.com/");
        var username  = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        var password =driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        var loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        var title = driver.findElement(By.className("Products"));
        Assert.assertEquals(title.getText(),"Products");
    }


    @Test
    void LoginFailureTest(){
        driver.get("https://www.saucedemo.com/");
        var username  = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        var password =driver.findElement(By.id("password"));
        password.sendKeys("*******");
        var loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        var errorText = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(errorText.getText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterTest
    void TearDown(){
        driver.quit();
    }
}

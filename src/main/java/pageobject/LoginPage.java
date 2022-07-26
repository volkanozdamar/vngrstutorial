package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorText = By.xpath("//h3[@data-test='error']");
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    private void enterUserName(String userNameText){
        driver.findElement(userName).sendKeys(userNameText);
    }

    private void enterPassword(String passwordText){
        driver.findElement(password).sendKeys(passwordText);
    }

    private void clickToLoginButton(){
        driver.findElement(loginButton).click();
    }

    private String errorText(){
        return driver.findElement(errorText).getText();
    }

    public void fillLoginForm(String userNameText,String passwordText){
        enterUserName(userNameText);
        enterPassword(passwordText);
        clickToLoginButton();
    }

    public String getErrorText(){
        return errorText();
    }

}

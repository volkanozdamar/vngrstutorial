package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
    WebDriver driver;

    public LoginFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id ="login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorText;


    private void enterUserName(String userNameText){
        userName.sendKeys(userNameText);
    }
    private void enterPassword(String passwordText){
        password.sendKeys(passwordText);
    }

    private void clickToLoginButton(){
        loginButton.click();
    }

    private String errorText(){
        return errorText.getText();
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

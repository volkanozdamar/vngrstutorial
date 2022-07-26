package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreFactory {
    WebDriver driver;

    @FindBy(className = "title")
    private WebElement pageHeader;


    public StoreFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private String storeHeaderText(){
        return pageHeader.getText();
    }


    public String getStoreHeaderText(){;
        return storeHeaderText();
    }
}

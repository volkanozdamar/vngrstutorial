package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage {

    WebDriver driver;

    By pageHeader = By.className("title");


    public StorePage(WebDriver driver) {
        this.driver=driver;
    }

    private String storeHeaderText(){
        return driver.findElement(pageHeader).getText();
    }


    public String getStoreHeaderText(){;
        return storeHeaderText();
    }
}

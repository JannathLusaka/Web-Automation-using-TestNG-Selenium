package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminWork {
    @FindBy(className = "search-box")
    WebElement searchBox;

    public AdminWork(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void searchUser(String userEmail){
        searchBox.sendKeys(userEmail);
    }
}

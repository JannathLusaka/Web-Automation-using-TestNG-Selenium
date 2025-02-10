package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UpdateUserProfile {
    @FindBy(css="[type=button]")
    WebElement btnElem;
    @FindBy(css="[role=menuitem]")
     List<WebElement> menuRole;

    //@FindBy(css="[type=button]")
    WebElement btnEdit;

    @FindBy(name="email")
    WebElement txtEmail;

    @FindBy(css="[type=button]")
    List<WebElement> btnUpdate;

    public UpdateUserProfile(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doUserEmailUpdate(String newEmail){
        btnElem.click();
        menuRole.get(0).click();
        btnUpdate.get(1).click();
        //clear email field
        txtEmail.sendKeys(Keys.CONTROL,"a");
        txtEmail.sendKeys(Keys.BACK_SPACE);
        txtEmail.sendKeys(newEmail);
        btnUpdate.get(2).click();
    }

    public void doLogout(){
        btnElem.click();
        menuRole.get(1).click();
    }
}

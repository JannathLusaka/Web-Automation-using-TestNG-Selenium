package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SetNewPassword {
    @FindBy(css="[type=password]")
    List<WebElement> txtPasswordField;

    @FindBy(css="[type=submit]")
    WebElement btnReset;

    public SetNewPassword(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void newPassword(String newPass,String confirmPass){
    txtPasswordField.get(0).sendKeys(newPass);
    txtPasswordField.get(1).sendKeys(confirmPass);
    btnReset.click();

    }
}

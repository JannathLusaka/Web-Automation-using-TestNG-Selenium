package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {
    @FindBy(css="[type=email]")
    WebElement txtEmail;

    @FindBy(css="[type=submit]")
            WebElement btnSumbit;
    public ResetPassword(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void resetPass(String email){
        txtEmail.sendKeys(Keys.CONTROL,"a");
        txtEmail.sendKeys(Keys.BACK_SPACE);
        txtEmail.sendKeys(email);
        btnSumbit.click();
    }

}

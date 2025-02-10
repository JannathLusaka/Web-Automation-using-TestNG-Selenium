package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(css="[type=submit]")
    WebElement btnSumbit;
    public UserLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String email,String password){
        txtEmail.sendKeys(Keys.CONTROL,"a");
        txtEmail.sendKeys(Keys.BACK_SPACE);
        txtEmail.sendKeys(email);

        txtPassword.sendKeys(Keys.CONTROL,"a");
        txtPassword.sendKeys(Keys.BACK_SPACE);
        txtPassword.sendKeys(password);
        btnSumbit.click();
    }
}

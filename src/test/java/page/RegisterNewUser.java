package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterNewUser {
   @FindBy(id= "firstName")
   WebElement txtFirstName;
   @FindBy(id="lastName")
    WebElement txtLastName;
   @FindBy(id="email")
    WebElement txtEmail;
   @FindBy(id="password")
    WebElement txtPassword;
   @FindBy(id="phoneNumber")
    WebElement txtPhoneNumber;
   @FindBy(id="address")
    WebElement txtAddress;
    @FindBy(css="[type=radio]")
    List<WebElement> btnRadio;
    @FindBy(css="[type=checkbox]")
    WebElement chkTerms;
    @FindBy(id="register")
    WebElement btnRegister;

public RegisterNewUser(WebDriver driver){
    PageFactory.initElements(driver,this);
}

    public void doRegister(String firstName,String lastName,
                           String email,String password,String phoneNumber,String address){
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtPhoneNumber.sendKeys(phoneNumber);
        txtAddress.sendKeys(address);
        btnRadio.get(1).click();
        chkTerms.click();
        btnRegister.click();
    }
}

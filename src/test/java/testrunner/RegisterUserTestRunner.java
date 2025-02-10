package testrunner;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.RegisterNewUser;
import setup.Setup;
import setup.Utils;

public class RegisterUserTestRunner extends Setup {
   @Test(description = "Check if new user can register.")
    public void userRegistration(){
    RegisterNewUser registerNewUser=new RegisterNewUser(driver);
      Faker faker=new Faker();
       driver.findElement(By.partialLinkText("Register")).click();
       String firstName=faker.name().firstName();
       String lastName=faker.name().lastName();
       String email="jannathlusaka+"+ Utils.generateRandomId(1,1000)+"@gmail.com";
       String password="1234";
       String phoneNumber="0170"+ Utils.generateRandomId(1000000,9999999);
       String address="Dhaka";
       registerNewUser.doRegister(firstName,lastName,email,password,phoneNumber,address);
   }
}

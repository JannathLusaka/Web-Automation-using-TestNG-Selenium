package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.UpdateUserProfile;
import page.UserLogin;
import setup.Setup;

public class NewEmailLoginTestRunner extends Setup {
    @Test(priority = 1,description = "Check if user can login with previous email.")
    public void LoginPreviousEmail(){
        UserLogin userLogin=new UserLogin(driver);
        String email="jannathlusaka@gmail.com";
        String password="5678";
        userLogin.doLogin(email,password);
        String msgExpected=driver.findElement(By.tagName("p")).getText();
        String msgActual="Invalid email or password";
        Assert.assertTrue(msgActual.contains(msgExpected),"Login Unsuccessful");
    }
   @Test(priority = 2, description = "Check if user can login with updated email.")
    public void LoginNewEmail(){
        UserLogin userLogin=new UserLogin(driver);
        String email="noorajannathlusaka@gmail.com";
        String password="5678";
        userLogin.doLogin(email,password);
       String headerActual= driver.findElement(By.tagName("h2")).getText();
       String headerExpected="User Daily Costs";
       Assert.assertTrue(headerActual.contains(headerExpected),"Login Successful");
       UpdateUserProfile updateUserProfile=new UpdateUserProfile(driver);
       updateUserProfile.doLogout();
    }
}

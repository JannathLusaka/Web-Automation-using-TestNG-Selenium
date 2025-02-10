package testrunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.UpdateUserProfile;
import page.UserLogin;
import setup.Setup;

public class UserUpdateTestRunner extends Setup {
    @BeforeTest
    public void Login(){
        UserLogin userLogin=new UserLogin(driver);
        String email="jannathlusaka@gmail.com";
        String password="5678";
        userLogin.doLogin(email,password);
    }
@Test(description = "Check if user can update email and do logout.")
    public void updateUserEmail() throws InterruptedException {
        UpdateUserProfile updateUserProfile=new UpdateUserProfile(driver);
        String newEmail="noorajannathlusaka@gmail.com";
        updateUserProfile.doUserEmailUpdate(newEmail);
    Thread.sleep(1000);
    driver.switchTo().alert().accept();
    updateUserProfile.doLogout();

    }

}

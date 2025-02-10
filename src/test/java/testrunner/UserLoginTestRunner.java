package testrunner;

import org.testng.annotations.Test;
import page.UserLogin;
import setup.Setup;

public class UserLoginTestRunner extends Setup {
    @Test(description = "Check if user can login with valid credentials.")
    public void Login() throws InterruptedException {
        Thread.sleep(5000);
        UserLogin userLogin=new UserLogin(driver);
        String email="jannathlusaka@gmail.com";
        String password="5678";
        userLogin.doLogin(email,password);
    }
}

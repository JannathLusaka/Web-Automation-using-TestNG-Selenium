package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AdminWork;
import page.UserLogin;
import setup.Setup;

import java.time.Duration;

public class AdminDashboardTestRunner extends Setup {
   @Test(priority = 1,description = "Check if Admin can login")
   public void adminLogin(){
       UserLogin userLogin=new UserLogin(driver);
       userLogin.doLogin(System.getProperty("email"),System.getProperty("password"));
   }
@Test(priority = 2,description = "Check if admin can search user")
   public void searchUser(){
       AdminWork adminWork=new AdminWork(driver);
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("total-count")));
       adminWork.searchUser("noorajannathlusaka@gmail.com");

       String userCount=driver.findElement(By.className("total-count")).getText();
       String userShows="Total Users: 1";
    Assert.assertTrue(userCount.contains(userShows));
    //System.out.println(userCount);

   }
}

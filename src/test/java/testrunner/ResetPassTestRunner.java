package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ResetPassword;
import setup.Setup;

public class ResetPassTestRunner extends Setup {
   @Test(priority = 1,description = "Check with non registered email if password can be reset")
    public void nonRegisterEmail() throws InterruptedException {
        Thread.sleep(5000);
        ResetPassword resetPassword=new ResetPassword(driver);
        driver.findElement(By.partialLinkText("Reset it here")).click();
        String email="habijabi@gmail.com";
        resetPassword.resetPass(email);
        Thread.sleep(1000);
       String msgActual= driver.findElement(By.tagName("p")).getText();
       String msgExpected="Your email is not registered";
       Assert.assertTrue(msgActual.contains(msgExpected));
    }
    //arekta negative test case lagbe
@Test(priority = 2,description = "Check with registered email if password can be reset.")
    public void registerdEmail(){
        ResetPassword resetPassword=new ResetPassword(driver);
        String email="jannathlusaka@gmail.com";
        resetPassword.resetPass(email);

    }
}

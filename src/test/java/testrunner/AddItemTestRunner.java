package testrunner;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AddNewItem;
import page.UserLogin;
import setup.Setup;

public class AddItemTestRunner extends Setup {
    @BeforeTest
    public void Login() throws InterruptedException {
        UserLogin userLogin=new UserLogin(driver);
        String email="jannathlusaka@gmail.com";
        String password="5678";
        Thread.sleep(5000);
        userLogin.doLogin(email,password);
    }
@Test(priority = 1, description = "Add first item with all the fields")
public void addFirstItem() throws InterruptedException {
    AddNewItem addNewItem=new AddNewItem(driver);
    String itemName="Mobile";
    String amount="100";
    String purchaseDate="01/31/2025";
    String month="January";
    String remarks="Good";
    addNewItem.addingItem(itemName,amount,purchaseDate,month,remarks);

Thread.sleep(2000);
driver.switchTo().alert().accept();

    String headerActual= driver.findElement(By.tagName("h2")).getText();
    String headerExpected="User Daily Costs";
    Assert.assertTrue(headerActual.contains(headerExpected),"Item Added");
}
    @Test(priority = 2, description = "Add Second item with only mandatory fields")
    public void addSecondItem() throws InterruptedException {
        AddNewItem addNewItem=new AddNewItem(driver);
        String itemName="Laptop";
        String amount="200";
        String purchaseDate="01/31/2025";
        String month="January";
        String remarks="";
        addNewItem.addingItem(itemName,amount,purchaseDate,month,remarks);

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        String headerActual= driver.findElement(By.tagName("h2")).getText();
        String headerExpected="User Daily Costs";
        Assert.assertTrue(headerActual.contains(headerExpected),"Item Added");
    }
}

package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddNewItem {
        @FindBy(className="add-cost-button")
        WebElement btnAddCost;

        @FindBy(id="itemName")
        WebElement txtItemName;

        @FindBy(css="[type=button]")
        List<WebElement> btnValue;
        @FindBy(id="amount")
        WebElement txtAmount;

        @FindBy(id="purchaseDate")
        WebElement txtDate;

        @FindBy(id="month")
        WebElement dropDownMonth;

        @FindBy(id="remarks")
        WebElement txtRemarks;

        @FindBy(css="[type=submit]")
        WebElement btnSubmit;

        public AddNewItem(WebDriver driver){
            PageFactory.initElements(driver,this);
        }

        public void addingItem(String itemName,String amount,
                               String purchaseDate,String month,String remarks){
                btnAddCost.click();
                txtItemName.sendKeys(itemName);
                btnValue.get(2).click();
                txtAmount.sendKeys(amount);

                txtDate.sendKeys(Keys.CONTROL,"a");
                txtDate.sendKeys(Keys.BACK_SPACE);
                txtDate.sendKeys(purchaseDate);

                Select option=new Select(dropDownMonth);
                option.selectByVisibleText(month);

                txtRemarks.sendKeys(remarks);

                btnSubmit.click();
        }
    }



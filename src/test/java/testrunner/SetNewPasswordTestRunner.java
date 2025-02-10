package testrunner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.build.Plugin;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SetNewPassword;
import setup.Setup;
import setup.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SetNewPasswordTestRunner extends Setup {
    Properties prop;

    public SetNewPasswordTestRunner() throws IOException {
        getEnvVar();
    }
    public void getEnvVar() throws IOException {
        prop=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }

    @BeforeTest
    public void getGmails() throws IOException, ConfigurationException, InterruptedException {
        Thread.sleep(5000);
        RestAssured.baseURI="https://gmail.googleapis.com";
        Response response=given().contentType("application/json")
                .header("Authorization","Bearer "+prop.getProperty("gmail_token")).
                when().get("/gmail/v1/users/me/messages");

        //System.out.println(response.asString());   //mail gula ashse

        JsonPath jsonPath=response.jsonPath();    //id first er ta
        String resetMailId=jsonPath.get("messages[0].id");
        //System.out.println(resetMailId);
        Utils.setEnvVar("reset_Mail_id",resetMailId);       //mailid save kora
    }
    @Test(priority = 1,description = "Check if user can reset password.")
    public void readExtractLink() throws IOException, InterruptedException, ConfigurationException {
        Thread.sleep(5000);
        RestAssured.baseURI = "https://gmail.googleapis.com";
        Response response = given().contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("gmail_token")).
                when().get("/gmail/v1/users/me/messages/" + prop.getProperty("reset_Mail_id"));

        // System.out.println(response.asString());   //mail ta ashse.

        JsonPath jsonPath = response.jsonPath();    //id first er ta
        String mailBody = jsonPath.get("snippet");
        //System.out.println(mailBody);//main mail ta ashse.

        int strtIndex = mailBody.indexOf("https://");
        int endIndex = mailBody.indexOf(" ", strtIndex);
        if (endIndex == -1) {
            endIndex = mailBody.length(); // no space,take the entire remaining string
        }
        String resetLink = mailBody.substring(strtIndex, endIndex).trim();
        System.out.println(resetLink);
        Utils.setEnvVar("reset_link", resetLink);
    }
    @Test(priority = 2)
        public void newPassword() throws InterruptedException {
        SetNewPassword setNewPassword=new SetNewPassword(driver);
       driver.get(prop.getProperty("reset_link"));
       String newPass="5678";
       String confirmPass="5678";
      setNewPassword.newPassword(newPass,confirmPass);
      Thread.sleep(3000);
    }
}


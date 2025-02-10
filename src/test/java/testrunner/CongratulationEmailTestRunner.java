package testrunner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CongratulationEmailTestRunner {
    Properties prop;

    public CongratulationEmailTestRunner() throws IOException {
        getEnvVar();
    }
    public void getEnvVar() throws IOException {
        prop=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }

@BeforeTest
    public void getGmailList() throws IOException, ConfigurationException, InterruptedException {
        Thread.sleep(5000);
        RestAssured.baseURI="https://gmail.googleapis.com";
        Response response=given().contentType("application/json")
                .header("Authorization","Bearer "+prop.getProperty("gmail_token")).
                when().get("/gmail/v1/users/me/messages");

        //System.out.println(response.asString());   //mail gula ashse

        JsonPath jsonPath=response.jsonPath();    //id first er ta
        String mailId=jsonPath.get("messages[0].id");
        System.out.println(mailId);
        Utils.setEnvVar("mail_id",mailId);       //mailid save kora
    }
@Test(description = "Check if new user receives congratulation email after registration.")
    public void readMail() throws IOException, InterruptedException {
        Thread.sleep(10000);
        RestAssured.baseURI="https://gmail.googleapis.com";
        Response response=given().contentType("application/json")
                .header("Authorization","Bearer "+prop.getProperty("gmail_token")).
                when().get("/gmail/v1/users/me/messages/"+prop.getProperty("mail_id"));

        //System.out.println(response.asString());   //mail ta ashse.

        JsonPath jsonPath=response.jsonPath();    //id first er ta
        String mailBody=jsonPath.get("snippet");
        System.out.println(mailBody);//main mail ta ashse.
    Assert.assertTrue(mailBody.contains("Welcome to our platform"));

    }
}


package framework;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import javax.rmi.CORBA.Util;
import javax.swing.text.Document;


public class ApiBaseClass {

    public static String baseuri="https://test.imimobilewallet.com/api";
    public static HashMap<String,String> walletHeaders;
    public  String apiKeyValue ="9e401298-a3dd-4939-bc54-56ae24160a51";
    public String contentTypeValue ="application/json";
    public String createPassJsonPath = System.getProperty("user.dir")+
            "\\src\\test\\testdata\\issueWalletPass.json";
    public static DocumentContext context;
    public JsonReader reader;
    public ApiBaseClass apiBaseClass;
    public Faker faker;



    public ApiBaseClass()
    {
      walletHeaders = new HashMap<>();
        faker = new Faker();
        reader= new JsonReader();
      walletHeaders.put("x-api-key",apiKeyValue);
      walletHeaders.put("content-type",contentTypeValue);
    }

    public HashMap<String,String> getHeaders()
    {
        return  walletHeaders;
    }

    public String creatWalletPass(String walletId)
    {
       String response= given().headers(getHeaders()).
                pathParam("walletId", walletId).
                when().
                body(JsonReader.jsonToString(createPassJsonPath)).
                post(baseuri + "/wallet/{walletId}/landing").then().assertThat().
                statusCode(200).and().body("$.data",not(empty())).and()
                .extract().response().asString();
       String pass = JsonPath.parse(response).read("$.content.passId");
       return pass;
          }

    public void verifyGetPassDetails(String passId)
    {
        given().headers(getHeaders()).
                pathParam("passId",passId).
                when().get(baseuri+"/pass/{passId}").then().
                assertThat().statusCode(200).and().
                body("content.passId",equalTo(passId));
    }

    public void validateUpdatePass(String passId)
    {
        String headerKey = reader.generateRandomString();
        String headerLabel = reader.generateRandomString();
        String headerValue = faker.hacker().adjective();
        String textHeader = faker.book().title();
         RestAssured.given().headers(getHeaders()).
                 when().body(reader.setUpdateWalletJson(passId,headerKey,headerLabel,
                 headerValue,textHeader)).
                 patch(baseuri+"/pass").then().
                 log().all().
                 assertThat().statusCode(200).and().
                 body("content.data['customHeaderFields[0].key']",equalTo(headerKey)).
                 body("content.data['customHeaderFields[0].label']",equalTo(headerLabel)).
                 body("content.data['customHeaderFields[0].value']",equalTo(headerValue)).
                 body("content.data['texts[0].header']",equalTo(textHeader));
    }

    public void getPublishedWallets()
    {
       String response= given().headers(getHeaders()).
                when().get(baseuri+"/wallet").then().
                log().all().
                assertThat().statusCode(200).and().extract().response().asString();
        JsonParser JSON = new JsonParser();
         JsonArray array = (JsonArray) JSON.parse(response);
         System.out.println("Total no of wallets are:=>"+array.size());



    }
}

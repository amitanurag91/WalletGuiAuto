package framework;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {

    private static Object obj;
    private static JsonObject jo;
    private static JsonPath jsonPath;
    public String updateWalletPassJsonPath = System.getProperty("user.dir")+
            "\\src\\test\\testdata\\updatePass.json";

    private static Faker faker;

    public JsonReader()
    {

    }

    public static String jsonToString(String path)  {
        try {
            obj = new JsonParser().parse(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // typecasting obj to JSONObject
        jo = (JsonObject) obj;
             return  jo.toString();
    }
    public String generateRandomString()
    {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public String setUpdateWalletJson(String passId,String headerKey,String headerLabel,
                                      String headerValue,String textHeader)
    {
        DocumentContext context= JsonPath.using(Configuration.
                defaultConfiguration()).parse(jsonToString(updateWalletPassJsonPath));

        context.set("$.passId",passId);
        context.set("$.data['customHeaderFields[0].key']",headerKey);
        context.set("$.data['customHeaderFields[0].label']",headerLabel);
        context.set("$.data['customHeaderFields[0].value']",headerValue);
        context.set("$.data['customHeaderFields[0].align']","PKTextAlignmentLeft");
        context.set("$.data['texts[0].header']",textHeader);


        return context.jsonString();
    }
}

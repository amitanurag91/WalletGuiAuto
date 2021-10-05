package util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUtil {

    HashMap<String,String> propMap = new HashMap<String,String>();
    Properties prop = new Properties();


    public HashMap<String,String> getAppProperties()
    {
        InputStream iStream=null;
        try {
            iStream = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//java//util//app.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(iStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       for(Map.Entry<Object,Object> entry:prop.entrySet())
       {
           propMap.put((String)entry.getKey(),(String)entry.getValue());

       }
       return  propMap;
    }
}

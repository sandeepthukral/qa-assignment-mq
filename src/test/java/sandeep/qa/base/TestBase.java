package sandeep.qa.base;

import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties prop;

    //TODO instantiate an object that reads data from the props file. Not using props.getPRoperty() everywhere

    public TestBase(){
        try{
            if (null == prop) {
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/java/sandeep/qa/config.properties");
                prop.load(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration.startMaximized = false;
        Configuration.browser = prop.getProperty("browser", "chrome");
        Configuration.browserSize = prop.getProperty("browser.size", "1280x1024");
        Configuration.baseUrl = prop.getProperty("base_url");
    }
}
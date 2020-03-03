package sandeep.qa.base;

import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestBase {

    public static Properties prop;
    public static Map<String, String> config;

    protected static final boolean REMOTE_DRIVER = Boolean.parseBoolean(System.getProperty("REMOTE_DRIVER", "false"));
    protected static final String BROWSER = System.getProperty("BROWSER", "chrome");

    public TestBase(){
        try {
            if (null == prop) {
                // Read the properties file
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/java/sandeep/qa/config.properties");
                prop.load(fis);

                // feed this to a hashmap
                config = new HashMap<String, String>();
                for (final String name : prop.stringPropertyNames())
                    config.put(name, prop.getProperty(name));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        Configuration.startMaximized = false;
        Configuration.browser = BROWSER;
        Configuration.browserSize = config.get("browser.size");
        Configuration.baseUrl = config.get("base_url");
        if (REMOTE_DRIVER) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.driverManagerEnabled = false;
        }
    }
}
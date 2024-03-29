package techproed.utilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) {

        Properties properties = new Properties(); //ilk iş obje oluşturmak

        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);
    }



}


package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static Properties load() {
        Properties p = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            p.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        return p;
    }
}

package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import framework.config.Config;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Config.BASE_URL;
    }
}

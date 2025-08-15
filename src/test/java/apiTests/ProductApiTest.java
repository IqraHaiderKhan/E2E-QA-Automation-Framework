
package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductApiTest {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void listProducts_shouldReturn200AndArray(){
        given().when().get("/products")
            .then().statusCode(200)
            .contentType(ContentType.JSON)
            .body("$", not(empty()));
    }

    @Test
    public void getProduct_shouldHaveIdAndTitle(){
        given().when().get("/products/1")
            .then().statusCode(200)
            .body("id", equalTo(1))
            .body("title", notNullValue());
    }
}

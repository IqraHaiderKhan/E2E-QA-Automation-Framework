package framework.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    static {
        RestAssured.useRelaxedHTTPSValidation(); // allows HTTPS
    }

    public static Response get(String endpoint) {
        return given()
                .header("Accept", "application/json")
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response post(String endpoint, String body) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response put(String endpoint, String body) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response delete(String endpoint) {
        return given()
                .header("Accept", "application/json")
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}

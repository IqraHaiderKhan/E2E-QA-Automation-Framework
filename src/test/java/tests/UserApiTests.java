package tests;

import framework.utils.ApiUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTests extends BaseTest {

    @Test
    public void getUsers_shouldReturnListOfUsers() {
        Response response = ApiUtils.get("/users?page=2");
        Assert.assertEquals(response.getStatusCode(), 200, "GET /users failed");
        Assert.assertTrue(response.asString().contains("email"));
    }

    @Test
    public void createUser_shouldReturn201() {
        String requestBody = """
            {
                "name": "morpheus",
                "job": "leader"
            }
        """;

        Response response = ApiUtils.post("/users", requestBody);
        Assert.assertEquals(response.getStatusCode(), 201, "POST /users failed");
        Assert.assertTrue(response.asString().contains("id"));
    }

    @Test
    public void updateUser_shouldReturn200() {
        String requestBody = """
            {
                "name": "morpheus",
                "job": "zion resident"
            }
        """;

        Response response = ApiUtils.put("/users/2", requestBody);
        Assert.assertEquals(response.getStatusCode(), 200, "PUT /users failed");
    }

    @Test
    public void deleteUser_shouldReturn204() {
        Response response = ApiUtils.delete("/users/2");
        Assert.assertEquals(response.getStatusCode(), 204, "DELETE /users failed");
    }
}

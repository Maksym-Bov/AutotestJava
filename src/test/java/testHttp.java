import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class testHttp {

    public static final String BASE_URL = "https://reqres.in";
    public static final String POST_USER = "/api/users/";
    public static final String REQUEST_BODY = "{\n" +
            "  \"name\": \"morpheus\",\n" +
            "  \"job\": \"leader\" \n}";
    public static final String REQUEST_BODY_PUT = "{\n" +
            "  \"name\": \"morpheus\",\n" +
            "  \"job\": \"zion resident\" \n}";
    public static final String USER_ID = "2";

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void getList() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("page", USER_ID)
                .when()
                .get(POST_USER)
                .then()
                .extract().response();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("2", response.jsonPath().getString("page"));
        assertEquals("6", response.jsonPath().getString("per_page"));
        assertEquals("12", response.jsonPath().getString("total"));
        assertEquals("2", response.jsonPath().getString("total_pages"));
    }
    @Test
    public void postCreate() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(REQUEST_BODY)
                .when()
                .post(POST_USER)
                .then()
                .extract().response();
      assertEquals(HttpStatus.SC_CREATED, response.statusCode());
      assertEquals("morpheus", response.jsonPath().getString("name"));
      assertEquals("leader", response.jsonPath().getString("job"));
    }
    @Test
    public void putList() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(REQUEST_BODY_PUT)
                .when()
                .put(POST_USER + USER_ID)
                .then()
                .extract().response();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertEquals("morpheus", response.jsonPath().getString("name"));
        assertEquals("zion resident", response.jsonPath().getString("job"));

    }
    @Test
    public void deleteList() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete(POST_USER + USER_ID)
                .then()
                .extract().response();
        assertEquals(HttpStatus.SC_NO_CONTENT, response.statusCode());

    }
}

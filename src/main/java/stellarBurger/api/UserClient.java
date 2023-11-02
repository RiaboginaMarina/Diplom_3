package stellarBurger.api;

import io.restassured.http.ContentType;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class UserClient {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    public void delete(String accessToken) {
        given()
                .baseUri(BASE_URI)
                .header("Authorization", accessToken)
                .delete("/api/auth/user")
                .then().statusCode(HttpURLConnection.HTTP_ACCEPTED);
    }

    public void createNewUser(User user) {
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/auth/register")
                .then().statusCode(HttpURLConnection.HTTP_OK);
    }
}

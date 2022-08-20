package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(String body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer a59b10684997179e9237348c230bb1e5c6ba7be44e030dea07f2f1e8cbe4e692")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}

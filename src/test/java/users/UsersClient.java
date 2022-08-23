package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse userErrorResponse = response.as(CreateUserErrorResponse.class);
        userErrorResponse.setStatusCode(response.statusCode());
        return userErrorResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response =
                given()
                  .contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .header("Authorization", "Bearer a59b10684997179e9237348c230bb1e5c6ba7be44e030dea07f2f1e8cbe4e692")
                  .body(body)
                .when()
                  .post("https://gorest.co.in/public/v1/users");

        response
                .then()
                .log().body();
        return response;
    }

    public Response getAllUsers() {
        return
                given()
                 .when()
                  .get("https://gorest.co.in/public/v1/users");
    }
}

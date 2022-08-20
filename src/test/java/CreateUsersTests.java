import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsersTests {

    @Test
    public void createMaleUser(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakri1937@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakri1937@gmail.com"))
                .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void createFemaleUser(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"P V Sindhu\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"pv.sindhu.937@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("pv.sindhu.937@gmail.com"))
                .body("data.name", Matchers.equalTo("P V Sindhu"));
    }

    private Response createUser(String body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer a59b10684997179e9237348c230bb1e5c6ba7be44e030dea07f2f1e8cbe4e692")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}

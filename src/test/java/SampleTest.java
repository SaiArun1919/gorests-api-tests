import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    @Test
    public void getAllUserDetails(){
        given()
                .when()
                  .get("https://gorest.co.in/public/v1/users")
                .then()
                  .statusCode(200)
                  .body("data",Matchers.hasSize(10))
                  .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                  .log().body();
    }

    @Test
    public void createUsers(){
        //Arrange
        //Act
        //Assert

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer a59b10684997179e9237348c230bb1e5c6ba7be44e030dea07f2f1e8cbe4e692")
                .body("{\n" +
                        "    \"name\": \"Tenali Ramakrishna\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"tenali.ramakri1935@gmail.com\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                  .post("https://gorest.co.in/public/v2/users")
                .then()
                  .log().body()
                  .statusCode(201)
                  .body("data.id", Matchers.notNullValue())
                  .body("data.email", Matchers.equalTo("tenali.ramakri1935@gmail.com"))
                  .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }
}

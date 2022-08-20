import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTests {

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


}

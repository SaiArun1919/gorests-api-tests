import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    @Test
    public void getAllUserDetails(){
        given()
                .when()
                  .get("https://gorest.co.in/public/v2/users")
                .then()
                  .statusCode(200)
                  .log().body();
    }
}

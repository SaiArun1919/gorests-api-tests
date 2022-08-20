import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersNegativeTests {

    @Test
    public void shouldNotAllowCreateUserForInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"P V Sindhu\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"pv.sindhu.937gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}

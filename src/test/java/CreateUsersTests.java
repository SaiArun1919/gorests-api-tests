import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersTests {

    @Test
    public void shouldCreateMaleUser(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakri1937@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakri1937@gmail.com"))
                .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldCreateFemaleUser(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"P V Sindhu\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"pv.sindhu.937@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("pv.sindhu.937@gmail.com"))
                .body("data.name", Matchers.equalTo("P V Sindhu"));
    }
}

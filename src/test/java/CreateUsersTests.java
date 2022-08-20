import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

public class CreateUsersTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n   " +
                " \"name\": \"Tenali Ramakrishna\",\n   " +
                " \"gender\": \"male\",\n   " +
                " \"email\": \"%s\",\n    " +
                "\"status\": \"active\"\n}",email);
        //Act
        usersClient.createUser(body)
                .then()
                 .log().body()
        //Assert
                 .statusCode(201)
                 .body("data.id", Matchers.notNullValue())
                 .body("data.email", Matchers.equalTo(email))
                 .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldCreateFemaleUser(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n   " +
                " \"name\": \"P V Sindhu\",\n  " +
                "  \"gender\": \"female\",\n   " +
                " \"email\": \"%s\",\n    " +
                "\"status\": \"active\"\n}",email);
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name", Matchers.equalTo("P V Sindhu"));
    }
}

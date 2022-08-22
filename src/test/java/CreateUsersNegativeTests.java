import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUsersNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowCreateUserForInvalidEmail(){
        //Arrange
        String name = "Tenali Ramakrishna";
        String gender = "male";
        String email = "Tenali.Ramakrishnagmail.com";
        String status = "active";
        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        //Act
        usersClient.createUser(requestBody)
                .then()
                 .log().body()

        //Assert
                 .statusCode(422)
                 .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                 .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}

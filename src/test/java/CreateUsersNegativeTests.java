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
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").gender("male")
                .email("Tenali.Ramakrishnagmail.com").status("active").build();

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

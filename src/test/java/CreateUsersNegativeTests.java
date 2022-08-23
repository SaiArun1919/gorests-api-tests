import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import java.util.UUID;

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
        CreateUserErrorResponse createUserErrorResponse= usersClient.createUserExpectingError(requestBody);

        //Assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(),422);
        createUserErrorResponse.assertHasError("email","is invalid");

    }

    @Test
    public void shouldNotAllowCreateUserWithBlankGenderAndStatus(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").gender("")
                .email(email).status("").build();

        //Act
        CreateUserErrorResponse createUserErrorResponse= usersClient.createUserExpectingError(requestBody);

        //Assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(),422);
        createUserErrorResponse.assertHasError("gender","can't be blank, can be male or female");
        createUserErrorResponse.assertHasError("status","can't be blank");

    }
}

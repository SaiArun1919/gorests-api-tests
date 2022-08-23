import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

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
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").gender("male")
                .email(email).status("active").build();
        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //Assert
        createUserResponse.assertUser(requestBody);
    }


    @Test
    public void shouldCreateFemaleUser(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("P V Sindhu").gender("female")
                .email(email).status("active").build();

        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //Assert
        createUserResponse.assertUser(requestBody);
    }
}

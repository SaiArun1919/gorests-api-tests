import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.getAll.GetAllUserResponse;

public class GetAllUsersTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
         usersClient = new UsersClient();
        }

    @Test
    public void getAllUserDetails(){
        GetAllUserResponse getAllUserResponse = usersClient.getAllUsers();

        Assert.assertEquals(getAllUserResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUserResponse.getDataItemList().size(),10);
        getAllUserResponse.hasMaleUser();
    }
}

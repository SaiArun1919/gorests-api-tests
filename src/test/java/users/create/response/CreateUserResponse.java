package users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.create.CreateUserRequestBody;

@Getter
public class CreateUserResponse{
	@Setter
	private int statusCode;

	private Data data;
	private String meta;

	public void assertUser(CreateUserRequestBody requestBody) {
		Assert.assertEquals(this.getStatusCode(),201);
		Assert.assertNotNull(this.getData().getId());
		Assert.assertEquals(this.getData().getEmail(), requestBody.getEmail());
		Assert.assertEquals(this.getData().getGender(), requestBody.getGender());
		Assert.assertEquals(this.getData().getName(), requestBody.getName());
		Assert.assertEquals(this.getData().getStatus(), requestBody.getStatus());
	}
}
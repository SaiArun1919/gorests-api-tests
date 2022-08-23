package users.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CreateUserErrorResponse {

    @Setter
    private int statusCode;

    private String meta;

    @JsonProperty("data")
    private List<Data> dataList;

    public void assertHasError(String field, String message) {
        int size = dataList.stream().filter(data -> data.getField().equals(field))
                .filter(data -> data.getMessage().equals(message))
                .collect(Collectors.toList())
                .size();
        Assert.assertEquals(size,1);
    }

    @Getter
    public static class Data{
        private String field;
        private String message;
    }

}

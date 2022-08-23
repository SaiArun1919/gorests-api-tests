package users.getAll;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public @Data class GetAllUserResponse{

	@Setter
	private int statusCode;

	@JsonProperty("data")
	private List<DataItem> dataItemList;
	private Meta meta;

	public boolean hasMaleUser() {
			return dataItemList.stream().filter(dataItem -> dataItem.getGender().equals("male"))
					.findFirst()
					.isPresent();
	}
}
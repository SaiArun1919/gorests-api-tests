package users.getAll;

import lombok.Data;

public @Data class Pagination{
	private int total;
	private int pages;
	private int limit;
	private Links links;
	private int page;
}
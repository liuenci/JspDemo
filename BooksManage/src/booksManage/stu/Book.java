package booksManage.stu;

public class Book {
	
	private String id;
	private String name;
	private String type;
	private String strsum;
	
	public Book(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStrsum() {
		return strsum;
	}

	public void setStrsum(String strsum) {
		this.strsum = strsum;
	}
	
}

package model;

import org.bson.Document;

public class Category extends Model 
{
	private int id;
	private String name;
	private String description;
	private int count_post;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return description;
	}
	public void setDetail(String description) {
		this.description = description;
	}
	public int getCount_post() {
		return count_post;
	}
	public void setCount_post(int count_post) {
		this.count_post = count_post;
	}
	
	public Category(String name, String description) {
		this.id = Model.getLastestID(CATEGORY) + 1;
		this.name = name;
		this.description = description;
		this.count_post = 0;
	}
	
	public static void Insert(Category category) {
		Insert(category.getId(), category.getName(), category.getDetail(), category.getCount_post());
	}
	
	public static void Insert(int id, String name, String description, int count_post) {
		Document doc = new Document("id", id)
							.append("name", name)
							.append("description", description)
							.append("count_post", count_post);
		Insert(doc, CATEGORY);				
	}
	
	
}

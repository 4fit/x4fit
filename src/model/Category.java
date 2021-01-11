package model;

import org.bson.Document;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import x4fit.Utilities;

public class Category extends Model 
{
	private int id;
	private String name;
	private String description;
	private int count_post;
	private String url;
	
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
	public int getCount_post() {
		return count_post;
	}
	public void setCount_post(int count_post) {
		this.count_post = count_post;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Category(String name, String description) {
		this.id = Model.getLastestID(CATEGORY) + 1;
		this.name = name;
		this.description = description;
		this.count_post = 0;
	}
	
	public static void Insert(Category category) {
		Insert(category.getId(), category.getName(), category.getDescription(), category.getCount_post());
	}
	
	public static void Insert(int id, String name, String description, int count_post) {
		String url = Utilities.createURL(name);
		Document doc = new Document("id", id)
							.append("name", name)
							.append("description", description)
							.append("count_post", count_post)
							.append("url", url);
		Insert(doc, CATEGORY);				
	}
	
	public static String Update(String url, String oldName, String newName, String description, int count_post) {
		String newURL = url;
		if (!oldName.equals(newName)) {
			newURL = Utilities.createURL(newName);
		}
		CATEGORY.updateOne(Filters.eq("url", url),
				Updates.combine(Updates.set("url", newURL), 
						Updates.set("name", newName), 
						Updates.set("description", description),
						Updates.set("count_post", count_post)));
		return newURL;		
	}
	
	public static boolean IncreaseCountPost(String categoryName) {
		try {
			CATEGORY.findOneAndUpdate(Filters.eq("name", categoryName), 
					Updates.inc("count_post", 1));
			return true;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}

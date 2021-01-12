package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import x4fit.Utilities;

public class Category extends Model 
{
	private int id;
	private String name;
	private String description;
	private String shortDes;
	private int count_post;
	private String url;
	
	public String getShortDes() {
		return shortDes;
	}
	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}
	
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
		this.shortDes = description;
		if (description.length() > 52) {
			this.shortDes = description.substring(0, 50);
		}
		this.count_post = 0;
	}
	
	public Category(int id, String name, String description, String shortDes, int count_post, String url) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.shortDes = shortDes;
		this.count_post = count_post;
		this.url = url;
	}
	
	public static Category Doc2Category(Document doc)
	{
		if (doc == null)
			return null;
		return new Category(
				doc.getInteger("id"), 
				doc.getString("name"), 
				doc.getString("description"),
				doc.getString("shortDes"),
				doc.getInteger("count_post"),
				doc.getString("url"));
	}
	
	public static List<Category> getAllCategories() {
		FindIterable<Document> cursor = CATEGORY.find();
		Iterator<Document> it = cursor.iterator();
		ArrayList<Category> listCategories = new ArrayList<Category>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				Category category = Category.Doc2Category(doc);
				listCategories.add(category);
			}
		}
		return listCategories;
	}
	
	public static void Insert(Category category) {
		Insert(category.getId(), category.getName(), category.getDescription(), category.getShortDes());
	}
	
	public static void Insert(int id, String name, String description, String shortDescription) {
		String url = Utilities.createURL(name);
		Document doc = new Document("id", id)
							.append("name", name)
							.append("description", description)
							.append("shortDes", shortDescription)
							.append("count_post", 0)
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
	
	public static boolean Delete(String url) {
		try {
			CATEGORY.deleteOne(Filters.eq("url", url));
			return true;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
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

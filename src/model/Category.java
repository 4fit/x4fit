package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import x4fit.Utilities;

public final class Category extends Model 
{
	private ObjectId id;
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
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
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
	
	public Category() {}
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
		this.shortDes = description;
		if (description.length() > 90) {
			this.shortDes = description.substring(0, 90) + "..." ;
		}
		this.count_post = 0;
		this.url = Utilities.createURL(name);
	}
	
	public Category(ObjectId id, String name, String description, String shortDes, int count_post, String url) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.shortDes = shortDes;
		this.count_post = count_post;
		this.url = url;
	}
	
	public static List<Category> getAllCategories() {
		FindIterable<Category> cursor = CATEGORY.find();
		Iterator<Category> it = cursor.iterator();
		ArrayList<Category> listCategories = new ArrayList<Category>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Category category = it.next();
				listCategories.add(category);
			}
		}
		return listCategories;
	}
	
	public void Insert() {
	 	CATEGORY.insertOne(this);
	}
	
	public static void Insert(String name, String description) {
		Category cat = new Category(name, description);
		CATEGORY.insertOne(cat);			
	}
	
	public static String Update(String url, String oldName, String newName, String description) {
		String newURL = url;
		if (!oldName.equals(newName)) {
			newURL = Utilities.createURL(newName);
		}
		String shortDes = description;
		if (description.length() > 90) {
			shortDes = description.substring(0, 90);
		}
		CATEGORY.updateOne(Filters.eq("url", url),
				Updates.combine(Updates.set("url", newURL), 
						Updates.set("name", newName), 
						Updates.set("description", description),
						Updates.set("shortDes", shortDes)));
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
	
	public static boolean existCategory(String categoryName) {
		try {
			Category cat = CATEGORY.find(Filters.eq("name", categoryName)).first();
			if (cat==null) return false;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static List<Category> search(String query) {
		FindIterable<Category> cursor = CATEGORY.find();
		Iterator<Category> it = cursor.iterator();
		ArrayList<Category> listCategories = new ArrayList<Category>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Category category = it.next();
				if (String.valueOf(category.getId()).equals(query)
						|| category.getName().equals(query)
						|| category.getDescription().equals(query)
						|| String.valueOf(category.getCount_post()).equals(query)) {
					listCategories.add(category);
				}
			}
		}
		return listCategories;
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

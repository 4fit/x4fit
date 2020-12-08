package dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import dao.DAO;
import model.Post;
import model.User;

public class UserDAO extends DAO {
	
	public static MongoCollection<Document> USER = db.getCollection("USER");
	
	public static User convertToUserObject(Document doc) {
		// Convert data từ mongo sang object User
		return new User(
				doc.getInteger("id"),
				doc.getString("username"),
				doc.getString("name"),
				doc.getString("password"),
				doc.getString("email"),
				doc.getString("avata"),
				doc.getInteger("posts_count")
		);
	}
	
	public static List<User> getAllUsers() {
		FindIterable<Document> cursor = USER.find();		
		Iterator<Document> it = cursor.iterator();
		List<User> data = new ArrayList<User>();	
		if(it.hasNext())
		{		
			while (it.hasNext()) {
				Document doc = it.next();
				User user = convertToUserObject(doc);
				data.add(user);
			}
		}
		return data;
	}
	
	public static Document getUserInfo(String user_id)
	{
		MongoCollection<Document> collection = DAO.db.getCollection("USER");
		return collection.find(Filters.eq("id", user_id)).first();
	}
	
	public static boolean deleteUserById(int user_id) {
		try {
			USER.deleteOne(Filters.eq("id", user_id));
			System.out.println("Delete user sucessfully!");
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

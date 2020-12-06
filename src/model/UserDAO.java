package model;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class UserDAO extends DAO {
	
	public static MongoCollection<Document> USER = db.getCollection("USER");
	
	public static Document getUserInfo(String user_id)
	{
		MongoCollection<Document> collection = DAO.db.getCollection("USER");
		return collection.find(Filters.eq("id", user_id)).first();
	}
}

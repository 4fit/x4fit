package model;

import model.DB_conn;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class User
{
	
	public User()
	{
		
	}
	//TODO
	public Document getUserInfo(String user_id)
	{
		MongoCollection<Document> collection = DB_conn.database.getCollection("USER");
		return collection.find(Filters.eq("id", user_id)).first();
	}
}

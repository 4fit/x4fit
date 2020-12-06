package model;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class DB_User extends DB_conn{

	public Document getUserInfo(String user_id)
	{
		int id = Integer.parseInt(user_id);
		MongoCollection<Document> collection = database.getCollection("USER");
		return collection.find(Filters.eq("id", id)).first();
	}
}

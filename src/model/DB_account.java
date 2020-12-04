package model;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class DB_account extends DB_conn {
	
	public User isLoginSuccess(String collectionName, Account acc)
	{
		MongoCollection<Document> collection = database.getCollection(collectionName);
		/*FindIterable<Document> iterDoc = collection.find(Filters.and(eq("username",  acc.getUsername()), eq("username",  acc.getUsername());
		Iterator<Document> it = iterDoc.iterator();*/
		BasicDBObject andQuery = new BasicDBObject();
		ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("username", acc.getUsername()));
		obj.add(new BasicDBObject("password", acc.getPassword()));
		andQuery.put("$and", obj);
		System.out.println(andQuery.toString());
		//DBCursor cursor = collection.find(andQuery);
		FindIterable<Document> cursor = collection.find(andQuery);
		
		//return cursor.first();
		Iterator<Document> it = cursor.iterator();
		
		if(it.hasNext())
		{
			String username= it.next().get("username").toString();
			String pass= it.next().get("password").toString();
			String email= it.next().get("email").toString();
			User user= new User(username, pass, email);
			return user;
		}
		
		return null;
	}
	
	public void signUpSuccess(Account acc)
	{
		Document doc  = new Document("_id", new ObjectId());
		doc.append("username", acc.getUsername());
		doc.append("password", acc.getPassword());
		doc.append("email", acc.getEmail());
		Insert(doc, "USER");
		
	}
}

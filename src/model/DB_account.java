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
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class DB_account extends DB_conn {
	
	public boolean isLoginSuccess(String collectionName, Account acc)
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
		Iterator<Document> it = cursor.iterator();
		
		if(it.hasNext())
			return true;
		return false;
		
	}
	
	public User isLoginSuccessGetUser(String collectionName, Account acc)
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
		Iterator<Document> it = cursor.iterator();
		
		if(it.hasNext())
			{
				Document doc = cursor.first();
				User user = new User(doc.getString("username"), doc.getString("password"), doc.getString("email"));
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

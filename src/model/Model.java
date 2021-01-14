package model;

import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Model 
{
	private static String mongoClientURI = "mongodb://tiennhm:m1nht13n@cluster0-shard-00-00.brj3o.mongodb.net:27017,cluster0-shard-00-01.brj3o.mongodb.net:27017,cluster0-shard-00-02.brj3o.mongodb.net:27017/X4FIT?ssl=true&replicaSet=atlas-emonwf-shard-0&authSource=admin&retryWrites=true&w=majority";
	private static MongoClientURI uri = new MongoClientURI(mongoClientURI);
	private static MongoClient mongoClient = new MongoClient(uri);
	public static MongoDatabase db = mongoClient.getDatabase("X4FIT2");
	
	

	Logger mongoLogger = Logger.getLogger( "org.mongodb.driver");
	
	public static MongoCollection<Document> POST = db.getCollection("POST");
	public static MongoCollection<Document> USER = db.getCollection("USER");
	public static MongoCollection<Document> CMT = db.getCollection("COMMENT");
	public static MongoCollection<Document> ACCOUNT = db.getCollection("ACCOUNT");
	public static MongoCollection<Document> AUTHENTICATION = db.getCollection("AUTHENTICATION");
	public static MongoCollection<Document> CATEGORY = db.getCollection("CATEGORY");
	public static MongoCollection<Document> GALLERY = db.getCollection("GALLERY");
	public static MongoCollection<Document> REPORT = db.getCollection("REPORT");
	
//	public Model()
//	{
//		//Kết nối đến CSDL
//		this.uri = new MongoClientURI(mongoClientURI);
//		this.mongoClient = new MongoClient(uri);
//		this.db = mongoClient.getDatabase("X4FIT2");
//
//	}
//	
	public static int isExitInArray(List<Integer> list, int x)
	{
		for(int i = 0; i < list.size(); i++)
			if(list.get(i) == x)
				return 1;
		return 0;
	}
	
	
	public static void Insert(Document doc, MongoCollection<Document> collection)
	{
		collection.insertOne(doc);
	}
	
	public static void Insert(Document doc, String collectionName)
	{
		MongoCollection<Document> collection = db.getCollection(collectionName);
		collection.insertOne(doc);
	}
	
	public static int getLastestID(String collectionName)
	{
		MongoCollection<Document> collection = db.getCollection(collectionName);
		Document lastInsertion = collection.find().sort(new BasicDBObject("_id", -1)).first();
		if(lastInsertion.get("id")==null) return 0;
		int id = Integer.parseInt(lastInsertion.get("id").toString());
		return id;
	}
	
	public static int getLastestID(MongoCollection<Document> collection)
	{
		Document lastInsertion = collection.find().sort(new BasicDBObject("_id", -1)).first();
		int id = 0;
		try{
			id = Integer.parseInt(lastInsertion.get("id").toString());
		}
		catch (Exception e) {
			
		}
		return id;
	}
	
	// Dùng để lấy userID từ session
	public static int Authenticator(String selector, String validator)
	{
		Document doc = AUTHENTICATION.find(
				Filters.and(
						Filters.eq("selector", selector), 
						Filters.eq("validator", validator))
				).first();
		if (doc != null)
			return doc.getInteger("user_id");
		return -1;
	}
}

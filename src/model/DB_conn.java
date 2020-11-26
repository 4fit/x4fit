package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DB_conn 
{
	private MongoClientURI uri;
	private MongoClient mongoClient;
	private String mongoClientURI = "mongodb://tiennhm:m1nht13n@cluster0-shard-00-00.brj3o.mongodb.net:27017,cluster0-shard-00-01.brj3o.mongodb.net:27017,cluster0-shard-00-02.brj3o.mongodb.net:27017/X4FIT?ssl=true&replicaSet=atlas-emonwf-shard-0&authSource=admin&retryWrites=true&w=majority";
	public MongoDatabase database;
	
	public DB_conn()
	{
		//Kết nối đến CSDL
		this.uri = new MongoClientURI(mongoClientURI);
		this.mongoClient = new MongoClient(uri);
		this.database = mongoClient.getDatabase("X4FIT");
	}
	
	public void Insert(Document doc, String collectionName)
	{
		MongoCollection<Document> collection = database.getCollection(collectionName);
		collection.insertOne(doc);
	}
	
	public String getLastestID(String collectionName)
	{
		MongoCollection<Document> collection = database.getCollection(collectionName);
		Document lastInsertion = collection.find().sort(new BasicDBObject("_id", -1)).first();
		String id = (String) lastInsertion.get("id");
		return id;
	}
	
	public Document getUserInfo(String user_id)
	{
		MongoCollection<Document> collection = database.getCollection("USER");
		Document doc = new Document();
		return doc;
	}
	
	public Document getTagInfo(String tag)
	{
		MongoCollection<Document> collection = database.getCollection("TAGS");
		Document doc = new Document();
		return doc;
	}
	
	public void Insert_Post(String title, String user_id, String content, boolean is_public, String thumbnail_url, String tags)
	{
		//id
		int currentPostId = Integer.parseInt(this.getLastestID("POST"));
		String id = Integer.toString(currentPostId + 1);
		//transliterated
		String transliterated = x4fit.Utilities.removeAccent(title);
		LocalDateTime currentDateTime = java.time.LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String published_at = currentDateTime.format(formatter);
		Document user = getUserInfo(user_id);
		
		Document doc = new Document("id", id)
							.append("title", title)
							.append("user_id", user_id)
							.append("transliterated", transliterated)
							.append("content", content)
							.append("published_at", published_at)
							.append("is_public", is_public)
							.append("thumbnail_url", thumbnail_url)
							.append("user", user);
		Insert(doc, "POST");
	}
}

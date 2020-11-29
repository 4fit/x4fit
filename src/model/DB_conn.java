package model;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

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
	
	public Integer getLastestID(String collectionName)
	{
		MongoCollection<Document> collection = database.getCollection(collectionName);
		Document lastInsertion = collection.find().sort(new BasicDBObject("_id", -1)).first();
		Integer id = (Integer) lastInsertion.get("id");
		return id;
	}
	
	
	//TODO
	public Document getTagInfo(String tag)
	{
		MongoCollection<Document> collection = database.getCollection("TAGS");
		Document doc = new Document();
		return doc;
	}
	
	//TODO
	public void getAllComments(String post_id)
	{
		MongoCollection<Document> collection = database.getCollection("POST");
		Document doc = collection.find(Filters.eq("id", post_id)).first();
		Bson cmts = (Bson) doc.get("comments");
	}
	

}

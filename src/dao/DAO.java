package dao;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.types.proto.Album;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DAO {
	private static String mongoClientURI = "mongodb://tiennhm:m1nht13n@cluster0-shard-00-00.brj3o.mongodb.net:27017,cluster0-shard-00-01.brj3o.mongodb.net:27017,cluster0-shard-00-02.brj3o.mongodb.net:27017/X4FIT?ssl=true&replicaSet=atlas-emonwf-shard-0&authSource=admin&retryWrites=true&w=majority";
	private static MongoClientURI uri = new MongoClientURI(mongoClientURI);
	private static MongoClient mongoClient = new MongoClient(uri);
	public static MongoDatabase db = mongoClient.getDatabase("X4FIT2");

	public DAO()
	{
		//Kết nối đến CSDL
		this.uri = new MongoClientURI(mongoClientURI);
		this.mongoClient = new MongoClient(uri);
		this.db = mongoClient.getDatabase("X4FIT");
	}
	
	public int isExitInArray(List<Integer> list, int x)
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
		int id = Integer.parseInt(lastInsertion.get("id").toString());
		return id;
	}
	
	//TODO
	public Document getTagInfo(String tag)
	{
		MongoCollection<Document> collection = db.getCollection("TAGS");
		Document doc = new Document();
		return doc;
	}
	
	//TODO
	public void getAllComments(String post_id)
	{
		MongoCollection<Document> collection = db.getCollection("POST");
		Document doc = collection.find(Filters.eq("id", post_id)).first();
		Bson cmts = (Bson) doc.get("comments");
	}
	
	
}

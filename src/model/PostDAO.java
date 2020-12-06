package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class PostDAO extends DAO {
	
	public static MongoCollection<Document> POST = db.getCollection("POST");
	
	public static int getPostID()
	{
		return DAO.getLastestID(POST) + 1;
	}
	
	public static void Insert_Post(Post p)
	{
		Insert_Post(p.getID(), p.getTitle(), p.getUser_id(), p.getP(), p.getContent(),
					p.getPublished_at(), p.getIs_public(), p.getViews_count(), p.getPoints(), 
					p.getClips_count(), p.getThumbnail_url(), p.getTags(), p.getUser());
	}
	
	public static void Insert_Post(int id, String title, String user_id, String p, String content,
							String published_at, boolean is_public, int views_count, int points, 
							int clips_count, String thumbnail_url, String tags, Document user)
	{
		Document doc = new Document("id", id)
							.append("title", title)
							.append("user_id", user_id)
							.append("p", p)
							.append("content", content)
							.append("published_at", published_at)
							.append("updated_at", published_at)
							.append("views_count", views_count)
							.append("points", points)
							.append("clips_count", clips_count)
							.append("is_public", is_public)
							.append("thumbnail_url", thumbnail_url)
							.append("user", user);
		DAO.Insert(doc, POST);
	}
	
	public static Post GetPost(String p)
	{
		Document doc = POST.find(Filters.eq("p", p)).first();
		if (doc == null)
			return new Post();
		Post post = new Post();
		try
		{
			post = Doc2Post(doc);
		}
		catch (Exception e) {
			
		}
		return post;
	}
	
	public static Post Doc2Post(Document doc)
	{
		return new Post(doc.getInteger("id"),
							  doc.getString("title"),
							  doc.getString("user_id"),
							  doc.getString("p"),
							  doc.getString("content"),
							  doc.getString("published_at"),
							  doc.getString("updated_at"),
							  doc.getBoolean("is_public"),
							  doc.getInteger("views_count"),
							  doc.getInteger("points"),
							  doc.getInteger("clips_count"),
							  doc.getString("thumbnail_url"),
							  doc.getString("tags"),
							  (Document) doc.get("user")
							  );
	}
	
	//Lấy tất cả các bài post của một user
	//Truyền vào user id
	
	public static List<Post> readAllPersonalPost(int iduser) {
		FindIterable<Document> cursor = POST.find(new BasicDBObject("user_id",iduser));		
		Iterator<Document> it = cursor.iterator();
		List<Post> data = new ArrayList<Post>();	
		if(it.hasNext())
		{		
			while (it.hasNext()) {
				Document doc = it.next();
				Post p = Doc2Post(doc);
				data.add(p);
			}
		}
		return data;
	
	}
		
	private MongoClient getMongoClient() {
		// TODO Auto-generated method stub
		return null;
	}
}

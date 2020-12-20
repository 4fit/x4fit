package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;


public class DetailPostDAO extends DAO {

	public Document getPostByIdPost(int idPost)
	{
		MongoCollection<Document> collection =  DAO.db.getCollection("POST");
		FindIterable<Document> listPost = collection.find(Filters.eq("id", idPost));
		
		return listPost.first();
	}
	
	public List<Post> getPostOfUser(int idUser)
	{
		List<Post> lPost = new ArrayList<Post>();
		MongoCollection<Document> collection  =  DAO.db.getCollection("POST");
		FindIterable<Document> listPost = collection.find(Filters.eq("user_id", idUser));
		Iterator<Document> list = listPost.iterator();
		while(list.hasNext())
		{
			lPost.add(ConverseToPost(list.next()));
		}
		
		return lPost;
	}
	
	public Post ConverseToPost(Document Obj)
	{
		Post p = new Post();
		p.setContent((String) Obj.get("content"));;
		p.setID(Integer.parseInt( Obj.get("id").toString()));
		p.setTitle((String) Obj.get("title"));
		if(Obj.get("published_at")!=null)
			p.setPublished_at(Obj.get("published_at").toString());
		p.setClips_count(Integer.parseInt(Obj.get("clips_count").toString()));
		p.setViews_count(Integer.parseInt(Obj.get("views_count").toString()));
		p.setUser_id((Obj.getInteger("user_id")));	 
		
		return p;
	}
	
	public void updateClipsCountOfPost(int idPost, int clipsCount)
	{
		BasicDBObject query  = new BasicDBObject();
		query.put("post_id", idPost);
		BasicDBObject newClipsDoc = new BasicDBObject();
		newClipsDoc.put("clips_count", clipsCount);
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newClipsDoc);
		MongoCollection<Document> collection =  DAO.db.getCollection("POST");
		collection.updateOne(query, updateObject);
	}
	
	public int countComment(String post_id)
	{
		return 1;
	}
	
}

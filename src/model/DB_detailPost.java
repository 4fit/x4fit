package model;

import java.util.ArrayList;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.sun.net.httpserver.Filter;

import org.bson.Document;
import org.bson.conversions.Bson;

public class DB_detailPost extends DB_conn {

	public Document getPostByIdPost(int idPost)
	{
		MongoCollection<Document> collection = database.getCollection("POST");
		FindIterable<Document> listPost = collection.find(Filters.eq("id", idPost));
		
		return listPost.first();
	}
	
	public Iterator<Document> getPostOfUser(String idUser)
	{
		MongoCollection<Document> collection  = database.getCollection("POST");
		FindIterable<Document> listPost = collection.find(Filters.eq("user_id", idUser));
		Iterator<Document> list = listPost.iterator();
		return list;
	}
	
	public Post ConverseToPost(Document Obj)
	{
		Post p = new Post();
		p.setP_content((String) Obj.get("content"));;
		p.setP_id(Integer.parseInt( Obj.get("id").toString()));
		p.setP_title((String) Obj.get("title"));
		if(Obj.get("published_at")!=null)
			p.setP_published_at(Obj.get("published_at").toString());
		p.setP_clips_count(Integer.parseInt(Obj.get("clips_count").toString()));
		p.setP_views_count(Integer.parseInt(Obj.get("views_count").toString()));
		p.setP_user_id(Obj.get("user_id").toString());	 
		return p;
	}
	
	/*public String getNameUserByIdUser(String idUser)
	{
		MongoCollection<Document> collection = database.getCollection("USER");
		FindIterable<Document> user = collection.find(Filters.eq("user_id", idUser));
		return(String)user.first().getString("");
	}*/
	
	public int countComment(String post_id)
	{
		return 1;
	}
}

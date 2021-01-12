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

	
	public void updateVote(String nameField, int idPost, int idUserVote) // Bao gồm upvote, downvote
	{
		Document post =getPostByIdPost(idPost);
		
		List<Integer> vote = (ArrayList<Integer>)post.get(nameField);
		if(isExitInArray(vote, idUserVote) == 0) // Kiểm tra xem user đó đã thực hiện vote chưa, nếu có thì không cần update
		{
			vote.add(idUserVote);
			
			BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh 
			query.put("id", idPost);
			
			BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
			newList.put(nameField, vote);
			
			BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
			updateObject.put("$set",newList);
			
			MongoCollection<Document> collection =   DAO.db.getCollection("Post");
			collection.updateOne(query, updateObject);
			
		}
	}
	
	public Document getPostByIdPost(int idPost)
	{
		MongoCollection<Document> collection =  DAO.db.getCollection("Post");
		FindIterable<Document> listPost = collection.find(Filters.eq("id", idPost));
		
		return listPost.first();
	}
	
	public void updateItem(String nameField, int user_id ,int post_id)
	{
		Document postDoc = new Document();
		postDoc = this.getPostByIdPost(post_id);
		
		List<Integer> listIdPost = new ArrayList<Integer>();
		listIdPost =(ArrayList)postDoc.get(nameField);
		
		if(isExitInArray(listIdPost, user_id) == 0)
		{
			listIdPost.add(user_id);
			
			BasicDBObject query = new BasicDBObject();
			query.put("id", post_id);
			
			BasicDBObject newList = new BasicDBObject();
			newList.put("clips", listIdPost);
			
			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set",newList);
			
			MongoCollection<Document> collection =   DAO.db.getCollection("Post");
			collection.updateOne(query, updateObject);
			
			updateCount("clips_count", post_id);
		}
	}
	
	public List<Post> getPostOfUser(int idUser)
	{
		List<Post> lPost = new ArrayList<Post>();
		MongoCollection<Document> collection  =  DAO.db.getCollection("Post");
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
		p.setUpvote((int[])Obj.get("upvote"));
		return p;
	}
	
	public void updateCount(String nameField,  int idMain)
	{
		Document post = this.getPostByIdPost(idMain);
		int count = post.getInteger(nameField) + 1;
		
		BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh 
		query.put("id", idMain);
		
		BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách count clip trong post
		newList.put(nameField, count);
		
		BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update count_clips
		updateObject.put("$set",newList);
		
		MongoCollection<Document> collection =   DAO.db.getCollection("Post");
		collection.updateOne(query, updateObject);
	}
	
//	
//	
//	
//	public void updateClipsCountOfPost(int idPost, int clipsCount)
//	{
//		BasicDBObject query  = new BasicDBObject();
//		query.put("post_id", idPost);
//		BasicDBObject newClipsDoc = new BasicDBObject();
//		newClipsDoc.put("clips_count", clipsCount);
//		BasicDBObject updateObject = new BasicDBObject();
//		updateObject.put("$set", newClipsDoc);
//		MongoCollection<Document> collection =  DAO.db.getCollection("POST");
//		collection.updateOne(query, updateObject);
//	}
	
	public int countComment(int post_id)
	{
		MongoCollection<Document> collection =  DAO.db.getCollection("Comment");
		FindIterable<Document> listCMT = collection.find(Filters.eq("post_id", post_id));
		Iterator<Document> lCMT = listCMT.iterator();
		
		int count = 0;
		while(lCMT.hasNext())
		{
			lCMT.next();
			count ++;
		}
		return count;
	}
	

	
	
	
}

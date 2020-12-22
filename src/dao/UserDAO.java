package dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import dao.DAO;
import model.Post;
import model.User;

public class UserDAO extends DAO {
	
	public static MongoCollection<Document> USER = db.getCollection("USER");
	
	public static User convertToUserObject(Document doc) {
		// Convert data từ mongo sang object User
		return new User(
				doc.getInteger("id"),
				doc.getString("username"),
				doc.getString("name"),
				doc.getString("password"),
				doc.getString("email"),
				doc.getString("avata"),
				doc.getInteger("posts_count"),
				doc.getInteger("following_count"),
				doc.getInteger("follower_count"),
				doc.getInteger("clips_count")
		);
	}
	
	public static List<User> getAllUsers() {
		FindIterable<Document> cursor = USER.find();		
		Iterator<Document> it = cursor.iterator();
		List<User> data = new ArrayList<User>();	
		if(it.hasNext())
		{		
			while (it.hasNext()) {
				Document doc = it.next();
				User user = convertToUserObject(doc);
				data.add(user);
			}
		}
		return data;
	}
	
	public static Document getUserInfo(int user_id)
	{
		MongoCollection<Document> collection = DAO.db.getCollection("USER");
		return collection.find(Filters.eq("id", user_id)).first();
	}
	
	
	public void addFollowingForIdUser(int idUserMain,int idUserFollow) // idUserMain là user sẽ được user đang đăng nhâp follow (idUserFollow)
	{
		Document user = getUserInfo(idUserFollow);
		int[] following = (int[])user.get("following");
		following[following.length] = idUserMain;
		
		
		//update following
		BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh 
		query.put("user_id", idUserFollow);
		
		BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách following
		newList.put("following", following);
		
		BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update following
		updateObject.put("$set",newList);
		
		MongoCollection<Document> collection =   DAO.db.getCollection("USER");
		collection.updateOne(query, updateObject);
	}
	

	
	
	//Yen them
		public Document getDocUserByEmail(String email)
		{
			MongoCollection<Document> collection =  DAO.db.getCollection("USER");
			FindIterable<Document> cursor = collection.find(Filters.eq("email", email));
			Iterator<Document> it = cursor.iterator();
			if(it.hasNext())
				return collection.find(Filters.eq("email", email)).first();
			else return null;
			
			
		}
		 // Yen them
		public Document getDocUserByUsername(String username)
		{
			MongoCollection<Document> collection =  DAO.db.getCollection("USER");
			FindIterable<Document> cursor = collection.find(Filters.eq("username", username));
			Iterator<Document> it = cursor.iterator();
			if(it.hasNext())
				return collection.find(Filters.eq("username", username)).first();
			else return null;
			
			
		}
		
		public Document getDocUserByIdUser(int user_id)
		{
			MongoCollection<Document> collection =  DAO.db.getCollection("USER");
			FindIterable<Document> cursor = collection.find(Filters.eq("user_id", user_id));
			Iterator<Document> it = cursor.iterator();
			if(it.hasNext())
				return collection.find(Filters.eq("user_id", user_id)).first();
			else return null;
			
			
		}
		
		
		//Yen them
		public void updateNewPass(String newPass, String username)
		{
			BasicDBObject query  = new BasicDBObject();
			query.put("username", username);
			
			BasicDBObject newPassDoc = new BasicDBObject();
			newPassDoc.put("password", newPass);
			
			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", newPassDoc);
			
			MongoCollection<Document> collection =   DAO.db.getCollection("USER");
			collection.updateOne(query, updateObject);
		}
		
		//Yen Them
		
		public void updateClipsItem(int user_id ,int post_id)
		{
			Document userDoc = new Document();
			userDoc = this.getDocUserByIdUser(user_id);
			
			List<Integer> listIdPost = new ArrayList<Integer>();
			listIdPost =(ArrayList)userDoc.get("clips_post");
			listIdPost.add(post_id);
			
			BasicDBObject query = new BasicDBObject();
			query.put("user_id", user_id);
			
			BasicDBObject newList = new BasicDBObject();
			newList.put("clips_post", listIdPost);
			
			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set",newList);
			
			MongoCollection<Document> collection =   DAO.db.getCollection("USER");
			collection.updateOne(query, updateObject);
		}
		
		
}

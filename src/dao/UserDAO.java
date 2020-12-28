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
		updateFollow("following", idUserFollow, idUserMain);		
		updateCount("following_count", idUserFollow);
		
		updateFollow("follower", idUserMain, idUserFollow);
		updateCount("follower_count", idUserMain);
		
	}
	
	public void updateCount(String nameField,  int idMain)
	{
		Document user = getUserInfo(idMain);
		int count = user.getInteger(nameField) + 1;
		
		BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh 
		query.put("id", idMain);
		
		BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
		newList.put(nameField, count);
		
		BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
		updateObject.put("$set",newList);
		
		MongoCollection<Document> collection =   DAO.db.getCollection("USER");
		collection.updateOne(query, updateObject);
	}
	
	
	// Follow bao gồm follower, following
	public void updateFollow(String nameField, int idMain, int id) // idMain là ai được update thuộc tính follow
	{
		Document user = getUserInfo(idMain);
		System.out.print(user.get(nameField));
		List<Integer> follow = (ArrayList<Integer>)user.get(nameField);
		if(isExitInArray(follow, id) == 0) // Kiểm tra xem user đó đã thực hiện follow chưa, nếu có thì không cần update
		{
			follow.add(id);
			
			BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh 
			query.put("id", idMain);
			
			BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
			newList.put(nameField, follow);
			
			BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
			updateObject.put("$set",newList);
			
			MongoCollection<Document> collection =   DAO.db.getCollection("USER");
			collection.updateOne(query, updateObject);
			
		}
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
			listIdPost =(ArrayList)userDoc.get("clips");
			
			if(isExitInArray(listIdPost, post_id) == 0)
			{
				listIdPost.add(post_id);
				
				BasicDBObject query = new BasicDBObject();
				query.put("id", user_id);
				
				BasicDBObject newList = new BasicDBObject();
				newList.put("clips", listIdPost);
				
				BasicDBObject updateObject = new BasicDBObject();
				updateObject.put("$set",newList);
				
				MongoCollection<Document> collection =   DAO.db.getCollection("USER");
				collection.updateOne(query, updateObject);
				
				updateCount("clips_count", user_id);
			}
		}
		
	public int getPostCountOfUser(int idUser)
	{
		MongoCollection<Document> collection =  DAO.db.getCollection("POST");
		FindIterable<Document> listPost = collection.find(Filters.eq("user_id", idUser));
		Iterator<Document> lPOST = listPost.iterator();
		
		int count = 0;
		while(lPOST.hasNext())
		{
			lPOST.next();
			count ++;
		}
		return count;
	}
}

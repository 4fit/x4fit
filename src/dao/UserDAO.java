package dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import model.Model;
import model.Post;
import model.User;

public class UserDAO  {
	
	public static MongoCollection<Document> USER = Model.USER;
	public static MongoCollection<Document> POST = Model.POST;
//	public static MongoCollection<Document> USER = userModel.USER;
	
	public static User convertToUserObject(Document doc) {
		// Convert data từ mongo sang object User
		
		int id = 0;
		String fullname = "";
		String username = "";
		String password = "";
		String avatar = "";
		String url = "";
		String email = "";
		ArrayList<Integer> follower = null;
		ArrayList<Integer> following = null;
		ArrayList<Integer> clips = null;
		
		if(doc.getInteger("id") != null)
			id = doc.getInteger("id");
		
		if(doc.getString("fullname")!= null)
			fullname = doc.getString("fullname");
		
		if(doc.getString("username")!= null)
			username = doc.getString("username");
		
		if(doc.getString("password")!= null)
			password = doc.getString("password");
		
		if(doc.getString("avatar")!= null)
			avatar = doc.getString("avatar");
		
		if(doc.getString("url")!= null)
			url = doc.getString("url");
		
		if(doc.getString("email")!= null)
			email = doc.getString("email");
		
		if(doc.get("follower")!= null)
			follower = (ArrayList<Integer>)doc.get("follower");
		
		if(doc.get("following")!= null)
			following = (ArrayList<Integer>)doc.get("following");
		
		if(doc.get("clips")!= null)
			clips = (ArrayList<Integer>)doc.get("clips");
		
		return new User( id,  fullname,  username,  password,  avatar,  url,  email,  follower,  following,  clips );
				
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
//		MongoCollection<Document> collection = DAO.db.getCollection("USER");
		return USER.find(Filters.eq("id", user_id)).first();
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
		
//		MongoCollection<Document> collection =   DAO.db.getCollection("USER");
		USER.updateOne(query, updateObject);
	}
	
	
	// Follow bao gồm follower, following
	public void updateFollow(String nameField, int idMain, int id) // idMain là ai được update thuộc tính follow
	{
		Document user = getUserInfo(idMain);
		System.out.print(user.get(nameField));
		List<Integer> follow = (ArrayList<Integer>)user.get(nameField);
		if(Model.isExitInArray(follow, id) == 0) // Kiểm tra xem user đó đã thực hiện follow chưa, nếu có thì không cần update
		{
			follow.add(id);
			
			BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh 
			query.put("id", idMain);
			
			BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
			newList.put(nameField, follow);
			
			BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
			updateObject.put("$set",newList);
			
//			MongoCollection<Document> collection =   DAO.db.getCollection("USER");
			USER.updateOne(query, updateObject);
			
		}
	}
	
	//Yen them
		public Document getDocUserByEmail(String email)
		{
//			MongoCollection<Document> collection =  DAO.db.getCollection("USER");
			FindIterable<Document> cursor = USER.find(Filters.eq("email", email));
			Iterator<Document> it = cursor.iterator();
			if(it.hasNext())
				return USER.find(Filters.eq("email", email)).first();
			else return null;
			
			
		}
		 // Yen them
		public Document getDocUserByUsername(String username)
		{
//			MongoCollection<Document> collection =  DAO.db.getCollection("USER");
			FindIterable<Document> cursor = USER.find(Filters.eq("username", username));
			Iterator<Document> it = cursor.iterator();
			if(it.hasNext())
				return USER.find(Filters.eq("username", username)).first();
			else return null;
			
			
		}
		
		public Document getDocUserByIdUser(int user_id)
		{
//			MongoCollection<Document> collection =  DAO.db.getCollection("USER");
			FindIterable<Document> cursor = USER.find(Filters.eq("user_id", user_id));
			Iterator<Document> it = cursor.iterator();
			if(it.hasNext())
				return USER.find(Filters.eq("user_id", user_id)).first();
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
			
//			MongoCollection<Document> collection =   DAO.db.getCollection("USER");
			USER.updateOne(query, updateObject);
		}
		
		
		
		//Yen Them
		
		public void updateClipsItem(int user_id ,int post_id)
		{
			Document userDoc = new Document();
			userDoc = this.getDocUserByIdUser(user_id);
			
			List<Integer> listIdPost = new ArrayList<Integer>();
			listIdPost =(ArrayList)userDoc.get("clips");
			
			if(Model.isExitInArray(listIdPost, post_id) == 0)
			{
				listIdPost.add(post_id);
				
				BasicDBObject query = new BasicDBObject();
				query.put("id", user_id);
				
				BasicDBObject newList = new BasicDBObject();
				newList.put("clips", listIdPost);
				
				BasicDBObject updateObject = new BasicDBObject();
				updateObject.put("$set",newList);
				
//				MongoCollection<Document> collection =   DAO.db.getCollection("USER");
				USER.updateOne(query, updateObject);
				
				updateCount("clips_count", user_id);
			}
		}
		
	public int getPostCountOfUser(int idUser)
	{
//		MongoCollection<Document> collection =  DAO.db.getCollection("POST");
		FindIterable<Document> listPost = POST.find(Filters.eq("user_id", idUser));
		Iterator<Document> lPOST = listPost.iterator();
		
		int count = 0;
		while(lPOST.hasNext())
		{
			lPOST.next();
			count ++;
		}
		return count;
	}
	
	public User isLoginSuccess(User acc)
	{
		
		
		BasicDBObject andQuery = new BasicDBObject();
		ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("username", acc.getUsername()));
		obj.add(new BasicDBObject("password", acc.getPassword()));
		andQuery.put("$and", obj);

		FindIterable<Document> cursor = USER.find(andQuery);
		
		//return cursor.first();
		Iterator<Document> its = cursor.iterator();
		
		if(its.hasNext())
		{
			Document it=cursor.first();
			
			User user = new User(it);
			return user ;
		}
		
		return null;
	}
	
}

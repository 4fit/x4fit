package dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Account;
import model.User;

public class AccountDAO extends DAO {

	
	//Kiểm tra đăng nhập và trả lại thông tin user
	public User isLoginSuccess(String collectionName, User acc)
	{
		MongoCollection<Document> collection = db.getCollection(collectionName);
		
		BasicDBObject andQuery = new BasicDBObject();
		ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("username", acc.getUsername()));
		obj.add(new BasicDBObject("password", acc.getPassword()));
		andQuery.put("$and", obj);

		FindIterable<Document> cursor = collection.find(andQuery);
		
		//return cursor.first();
		Iterator<Document> its = cursor.iterator();
		
		if(its.hasNext())
		{
			Document it=cursor.first();
//			String username= it.get("username").toString();
//			String pass= it.get("password").toString();
//			String email= it.get("email").toString();	
//			int post_count;
//			if( it.getInteger("posts_count")==null)
//			{
//				post_count=0;
//			}
//			else
//			post_count= it.getInteger("posts_count");
//			String avatar= it.getString("avata");
//			String name;
//			if(it.get("name")!=null)
//			name= it.get("name").toString();
//			else name="";
//			int following_count=0;
//			if(it.get("following_count")!=null)
//			{
//				following_count=Integer.parseInt(it.get("following_count").toString());
//			}
//			int follower_count=0;
//			if(it.get("follower_count")!=null)
//			{
//				follower_count=Integer.parseInt(it.get("follower_count").toString());
//				
//			}
//			int id=1;
//			if(DAO.getLastestID("USER")!=0)
//			{
//				id= DAO.getLastestID("USER");
//			}
//			int clips_count=0;
//			if(it.getInteger("clips_count")!=null)
//			{
//				clips_count= it.getInteger("clips_count");
//			}
//			User user= new User(id, username, name, pass, email,avatar,post_count, follower_count, following_count, clips_count);
			User user = new User(it);
			return user ;
		}
		
		return null;
	}
	
	public void signUpSuccess(User user)
	{
		Document doc  = new Document("_id", new ObjectId());
		
		
		doc.append("id", DAO.getLastestID("User") + 1);
		doc.append("username", user.getUsername());
		doc.append("password", user.getPassword());
		doc.append("email",user.getEmail());
		doc.append("name",user.getName());
		doc.append("posts_count", user.getPostsCount());
		doc.append("following_count", user.getFollowing_count());
		doc.append("follower_count",user.getFollower_count());
		doc.append("clips_count", user.getClips_count());
		doc.append("follower",user.getFollower());
		doc.append("following", user.getFollowing());
		doc.append("clips", user.getClips());
		DAO.Insert(doc, "User");
		
	}
}

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

public class User extends Account {
	private int userID;
	private String fullname;
	private String avatar;
	private String url;
	private String status;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;

	}

	public String getAvatar() {
		if (this.avatar == "")
			return "avt.png";
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEmail(int userID)
	{
		return Account.GetAccountByUserID(userID).getEmail();
	}

	public String getUsername(int userID)
	{
		return Account.GetAccountByUserID(userID).getUsername();
	}

	public User() {
		super();
	}

	public User(int userID, String fullname) 
	{
		super();
		this.setUserID(userID);
		this.setFullname(fullname);
		this.setAvatar("avt.png");
		this.setStatus("OK");

		String username = Account.GetAccountByUserID(userID).getUsername();
		this.setUrl(username + Integer.toString(userID));
	}

	public User(int userID, String fullname, String avatar, String url, String status) 
	{
		super();
		this.setUserID(userID);
		this.setFullname(fullname);
		this.setAvatar(avatar);
		this.setUrl(url);
		this.setStatus(status);
	}

	public User(int userID, String fullname, String avatar, String url, 
			String status, String username, String password, String email, String user_type) {
		super();
		this.userID = userID;
		this.fullname = fullname;
		this.avatar = avatar;
		this.url = url;
		this.status = status;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_type = user_type;
	}
	
	public static User Doc2User(Document doc) 
	{
		return new User(
				doc.getInteger("id"), 
				doc.getString("fullname"), 
				doc.getString("avatar"),
				doc.getString("url"),
				doc.getString("status"),
				doc.getString("username"),
				doc.getString("password"),
				doc.getString("email"),
				doc.getString("user_type"));
	}
	
	public static User Doc2UserFullInfo(Document doc) 
	{
		return new User(
				doc.getInteger("id"), 
				doc.getString("fullname"), 
				doc.getString("avatar"),
				doc.getString("url"),
				doc.getString("status"));
	}
	
	public static ArrayList<User> getAllUsers() {
		FindIterable<Document> cursor = USER.find();
		Iterator<Document> it = cursor.iterator();
		ArrayList<User> data = new ArrayList<User>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				User user = Doc2UserFullInfo(doc);
				data.add(user);
			}
		}
		return data;
	}
	
	public void updateCount(String nameField, int idMain) {
		Document user = GetUserDocumentByUserID(idMain);
		int count = user.getInteger(nameField) + 1;

		BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh
		query.put("id", idMain);

		BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
		newList.put(nameField, count);

		BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
		updateObject.put("$set", newList);

		USER.updateOne(query, updateObject);
	}

	public static User getUserByEmail(String email) {
		FindIterable<Document> cursor = ACCOUNT.find(Filters.eq("email", email));
		Iterator<Document> it = cursor.iterator();
		if (it.hasNext()) {
			Document doc = USER.find(Filters.eq("email", email)).first();
			return Doc2User(doc);
		} else
			return null;
	}

	public static User getUserByUsername(String username) 
	{
		Document doc = ACCOUNT.find(Filters.eq("username", username)).first();
		if (doc!=null)
		{
			int userID = doc.getInteger("user_id");
			Document user = USER.find(Filters.eq("id", userID)).first();
			return Doc2User(user);
		}
		else return null;
	}

	public static User GetUserByUserID(int userID) {
		Document doc = USER.find(Filters.eq("id", userID)).first();
		if (doc == null)
			return null;
		return Doc2User(doc);
	}
	

	public static int GetUserIDFromCookies(Cookie[] cookie) 
	{
		String selector = "", validator = "";
		for (Cookie c : cookie) {
			if (c.getName().equals("selector"))
			{
				System.out.print(c.getValue());
				selector = c.getValue();
			}
			if (c.getName().equals("validator"))
			{
				System.out.print(c.getValue());
				validator = c.getValue();
			}	
		}
		int userID = Model.Authenticator(selector, validator);
		System.out.print(userID);
		return userID;
	}
	
	public static User GetUserInfoFromCookies(Cookie[] cookie) 
	{
		int userID = GetUserIDFromCookies(cookie);
		Document doc = USER.find(Filters.eq("id", userID)).first();
		if (doc != null)
		{
			return Doc2User(doc);
		}
		else return null;
	}
	
	public static Document GetUserDocumentByUserID(int userID) {

		Document cursor = USER.find(Filters.eq("id", userID)).first();
		return cursor;
	}
	
	public static void updateNewPass(String newPass, String username) {
		BasicDBObject query = new BasicDBObject();
		query.put("username", username);

		BasicDBObject newPassDoc = new BasicDBObject();
		newPassDoc.put("password", newPass);

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newPassDoc);

		USER.updateOne(query, updateObject);
	}
}

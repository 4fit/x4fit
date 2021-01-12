package model;

import java.util.ArrayList;
<<<<<<< HEAD

=======
import java.util.Arrays;
>>>>>>> fd08f0aae3a478bec33a0a6c87f52a739184f8ab
import java.util.Iterator;
import java.util.List;

import javax.print.Doc;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

<<<<<<< HEAD
=======
import x4fit.Utilities;
>>>>>>> fd08f0aae3a478bec33a0a6c87f52a739184f8ab

public class User extends Model {
	
	
	private int userID;
	private String fullname;
	private String username;
	private String password;
	private String email;
	private String avatar;
	private String url;
<<<<<<< HEAD
	private ArrayList<Integer> follower;
	private ArrayList<Integer> following;
	private ArrayList<Integer> clips;
	
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
=======
	private List<Integer> follower;
	private List<Integer> following;
	private List<Integer> clips;
	private String status;
>>>>>>> fd08f0aae3a478bec33a0a6c87f52a739184f8ab

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

	public List<Integer> getFollower() {
		return follower;
	}

	public void setFollower(List<Integer> follower) {
		this.follower = follower;
	}

	public List<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(List<Integer> following) {
		this.following = following;
	}

	public List<Integer> getClips() {
		return clips;
	}

	public void setClips(List<Integer> clips) {
		this.clips = clips;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User() {

	}
	
	public User(int id, String fullname, String username, String password, String avatar, String url, String email, ArrayList<Integer> follower, ArrayList<Integer> following, ArrayList<Integer> clips )
	{
		
		this.userID = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.url = url;
		this.email = email;
		this.follower = follower;
		this.following = following;
		this.clips = clips;
		
	}

	public User(int userID, String fullname) 
	{
		List<Integer> empty = Arrays.asList();
		this.setUserID(userID);
		this.setFullname(fullname);
		this.setAvatar("avt.png");
		this.setStatus("OK");
		this.setClips(empty);
		this.setFollower(empty);
		this.setFollowing(empty);

		String username = Account.GetAccountByUserID(userID).getUsername();
		this.setUrl(username + Integer.toString(userID));
	}

	public User(int userID, String fullname, String avatar, String url, 
			List<Integer> clips, List<Integer> following, List<Integer> follower) 
	{
		this.setUserID(userID);
		this.setFullname(fullname);
		this.setAvatar(avatar);
		this.setUrl(url);
		this.setClips(clips);
		this.setFollower(follower);
		this.setFollowing(following);
		this.setStatus("OK");
	}

	@SuppressWarnings("unchecked")
	public static User Doc2User(Document doc) {
		List<Integer> clips = (List<Integer>) Utilities.convertObjectToList(doc.get("clips"));
		ArrayList<Integer> following = (ArrayList<Integer>) Utilities.convertObjectToList(doc.get("following"));
		ArrayList<Integer> follower = (ArrayList<Integer>) Utilities.convertObjectToList(doc.get("follower"));
		return new User(doc.getInteger("id"), doc.getString("fullname"), doc.getString("avatar"),
				doc.getString("url"), clips, following, follower);
	}

	public static ArrayList<User> getAllUsers() {
		FindIterable<Document> cursor = USER.find();
		Iterator<Document> it = cursor.iterator();
		ArrayList<User> data = new ArrayList<User>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				User user = Doc2User(doc);
				data.add(user);
			}
		}
		return data;
	}

<<<<<<< HEAD

	public void addFollowingForIdUser(int idUserMain, int idUserFollow) // idUserMain là user sẽ được user đang đăng
																		// nhâp follow (idUserFollow)
	{
		updateFollow("following", idUserFollow, idUserMain);
		updateCount("following_count", idUserFollow);

		updateFollow("follower", idUserMain, idUserFollow);
		updateCount("follower_count", idUserMain);

	}

=======
>>>>>>> fd08f0aae3a478bec33a0a6c87f52a739184f8ab
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

	// Follow bao gồm follower, following
//	public void updateFollow(String nameField, int idMain, int id) // idMain là ai được update thuộc tính follow
//	{
//		Document user = GetUserDocumentByUserID(idMain);
//		System.out.print(user.get(nameField));
//		List<Integer> follow = (ArrayList<Integer>) user.get(nameField);
//		if (isExitInArray(follow, id) == 0) // Kiểm tra xem user đó đã thực hiện follow chưa, nếu có thì không cần
//											// update
//		{
//			follow.add(id);
//
//			BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh
//			query.put("id", idMain);
//
//			BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
//			newList.put(nameField, follow);
//
//			BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
//			updateObject.put("$set", newList);
//
//			USER.updateOne(query, updateObject);
//
//		}
//	}

	public static User getUserByEmail(String email) {
		FindIterable<Document> cursor = USER.find(Filters.eq("email", email));
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
			int userID = doc.getInteger("userID");
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
	
<<<<<<< HEAD
	public static Document GetUserDocumentByUserID(int userID)
	{
=======
	public static int GetUserIDFromCookies(Cookie[] cookie) 
	{
		String selector = "", validator = "";
		for (Cookie c : cookie) {
			if (c.getName().equals("selector"))
				selector = c.getValue();
			if (c.getName().equals("validator"))
				validator = c.getValue();
		}
		int userID = Model.Authenticator(selector, validator);
		return userID;
	}
	
	public static User GetUserInfoFromCookies(Cookie[] cookie) 
	{
		int userID = GetUserIDFromCookies(cookie);
		Document doc = USER.find(Filters.eq("userID", userID)).first();
		if (doc != null)
			return Doc2User(doc);
		else return null;
	}
	
	public static Document GetUserDocumentByUserID(int userID) {
>>>>>>> fd08f0aae3a478bec33a0a6c87f52a739184f8ab
		FindIterable<Document> cursor = USER.find(Filters.eq("userID", userID));
		Iterator<Document> it = cursor.iterator();
		if (it.hasNext()) {
			return USER.find(Filters.eq("userID", userID)).first();
		} else
			return null;
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
	
	public static void updateClipsItem(int userID, int postID) {
		User user = User.GetUserByUserID(userID);

		List<Integer> listIdPost = user.getClips();

		if (isExitInArray(listIdPost, postID) == 0) {
			listIdPost.add(postID);

			BasicDBObject query = new BasicDBObject();
			query.put("id", userID);

			BasicDBObject newList = new BasicDBObject();
			newList.put("clips", listIdPost);

			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", newList);

			USER.updateOne(query, updateObject);
		}
	}
	
	public static User GetUserInfoFromSession(HttpSession session) {
		String selector = session.getAttribute("selector").toString();
		String validator = session.getAttribute("validator").toString();
		int userID = Model.Authenticator(selector, validator);
		Document doc = USER.find(Filters.eq("userID", userID)).first();
		if (doc != null)
			return Doc2User(doc);
		else return null;
		
	}
	
	
}
	

	
	/*
<<<<<<< HEAD
=======
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
=======
	
>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
	}
	

	

	
	}
}*/

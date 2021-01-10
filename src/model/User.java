package model;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.print.Doc;
import javax.servlet.http.HttpSession;


import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

<<<<<<< HEAD
import dao.DAO;

public class User
{	
	private int userId;
	private String username;
	private String name;
	private String password;
	private String email;
	private String avata;
	private int posts_count;
	private int following_count;
	private int follower_count;	
	private int clips_count;
	private ArrayList<Integer> follower  ; // Tạo mảng follower
	private ArrayList<Integer> following; // Tạo mảng following
	private ArrayList<Integer> clips; // Tạo mảng clips id bài post
	
	
	public ArrayList<Integer> getClips() {
		return clips;
	}

	public void setClips(ArrayList<Integer> clips) {
		this.clips = clips;
	}

	public User(int userId, String username, 
			String name, String pass, String email, 
			String avata, int posts_count, int following_count, int follower_count, int clips_count) {
		this.userId = userId;
		this.username= username;
		this.name = name;
		this.password= pass;
		this.email= email;
		this.avata = avata;
		this.posts_count = posts_count;
		this.following_count= following_count;
		this.follower_count = follower_count;
		this.clips_count= clips_count;
	}
	
	public User(String username, String pass, String email ) {
		
		this.username= username;
		this.password= pass;
		this.email= email;
		this.setClips_count(0);
		this.setFollower_count(0);
		this.setFollowing_count(0);
		this.setPostsCount(0);
		this.setName("");
		this.setAvata("");
		ArrayList<Integer> follow  = new ArrayList<Integer>(); // set số lượng follow
		this.setFollower(follow);
		this.setFollowing(follow);
		this.setClips(follow);
		//System.out.print("Da toi luc tao nhan viên");
		
		
		this.userId=(int) DAO.getLastestID("USER")+1;
		
	
	}
	
	public User()
	{
		
=======
public class User extends Model {
	private int userID;
	private String fullname;
	private String avatar;
	private String url;
	private ArrayList<Integer> follower;
	private ArrayList<Integer> following;
	private ArrayList<Integer> clips;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
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

	public ArrayList<Integer> getFollower() {
		return follower;
	}

	public void setFollower(ArrayList<Integer> follower) {
		this.follower = follower;
	}

	public ArrayList<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<Integer> following) {
		this.following = following;
	}

	public ArrayList<Integer> getClips() {
		return clips;
	}

	public void setClips(ArrayList<Integer> clips) {
		this.clips = clips;
	}

	public User() {

	}

	public User(int userID, String fullname) {
		this.setUserID(userID);
		this.setFullname(fullname);
		this.setAvatar("avt.png");
		this.setClips(new ArrayList<Integer>());
		this.setFollower(new ArrayList<Integer>());
		this.setFollowing(new ArrayList<Integer>());

		String username = Account.GetAccountByUserID(userID).getUsername();
		this.setUrl(username + Integer.toString(userID));
	}

	public User(int userID, String fullname, String avatar, String url, ArrayList<Integer> clips,
			ArrayList<Integer> following, ArrayList<Integer> follower) {
		this.setUserID(userID);
		this.setFullname(fullname);
		this.setAvatar(avatar);
		this.setUrl(url);
		this.setClips(clips);
		this.setFollower(follower);
		this.setFollowing(following);
	}

	public static User Doc2User(Document doc) {
		ArrayList<Integer> clips = new ArrayList<Integer>();// (ArrayList<Integer>) doc.get("clips");
		ArrayList<Integer> following = new ArrayList<Integer>();//(ArrayList<Integer>) doc.get("following");
		ArrayList<Integer> follower = new ArrayList<Integer>();//(ArrayList<Integer>) doc.get("follower");
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
	
	public ArrayList<Integer> getFollower() {
		return follower;
	}

	public void setFollower(ArrayList<Integer> follower) {
		this.follower = follower;
	}

	public ArrayList<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<Integer>following) {
		this.following = following;
=======

	public void addFollowingForIdUser(int idUserMain, int idUserFollow) // idUserMain là user sẽ được user đang đăng
																		// nhâp follow (idUserFollow)
	{
		updateFollow("following", idUserFollow, idUserMain);
		updateCount("following_count", idUserFollow);

		updateFollow("follower", idUserMain, idUserFollow);
		updateCount("follower_count", idUserMain);

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

	// Follow bao gồm follower, following
	public void updateFollow(String nameField, int idMain, int id) // idMain là ai được update thuộc tính follow
	{
		Document user = GetUserDocumentByUserID(idMain);
		System.out.print(user.get(nameField));
		List<Integer> follow = (ArrayList<Integer>) user.get(nameField);
		if (isExitInArray(follow, id) == 0) // Kiểm tra xem user đó đã thực hiện follow chưa, nếu có thì không cần
											// update
		{
			follow.add(id);

			BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh
			query.put("id", idMain);

			BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
			newList.put(nameField, follow);

			BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
			updateObject.put("$set", newList);

			USER.updateOne(query, updateObject);

		}
	}

	public static User getUserByEmail(String email) {
		FindIterable<Document> cursor = USER.find(Filters.eq("email", email));
		Iterator<Document> it = cursor.iterator();
		if (it.hasNext()) {
			Document doc = USER.find(Filters.eq("email", email)).first();
			return Doc2User(doc);
		} else
			return null;

>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
	}

	public static User getUserByUsername(String username) {
		FindIterable<Document> cursor = USER.find(Filters.eq("username", username));
		Iterator<Document> it = cursor.iterator();
		if (it.hasNext()) {
			Document doc = USER.find(Filters.eq("username", username)).first();
			return Doc2User(doc);
		} else
			return null;

	}

	public static User GetUserByUserID(int userID) {
		Document doc = USER.find(Filters.eq("id", userID)).first();
		if (doc == null)
			return null;
		return Doc2User(doc);
	}
	
<<<<<<< HEAD
	
	public void setID(int id) {
		this.userId = id;
	}
	
	
	public User(Document userDoc)
	{
		System.out.print(userDoc);
		this.setID(userDoc.getInteger("id"));
		this.setName(userDoc.getString("name"));
		this.setUsername(userDoc.getString("username"));
		this.setPassword(userDoc.getString("password"));
		this.setFollower_count(userDoc.getInteger("follower_count"));
		this.setFollowing_count(userDoc.getInteger("following_count"));
		this.setFollower((ArrayList<Integer>)userDoc.get("follower"));
		this.setClips((ArrayList<Integer>)userDoc.get("clips"));
		this.setFollowing((ArrayList<Integer>)userDoc.get("following"));
		this.setPostsCount(userDoc.getInteger("posts_count"));
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
	public static User GetUserInfoFromSession(HttpSession session) {
		String selector = session.getAttribute("selector").toString();
		String validator = session.getAttribute("validator").toString();
		int userID = Model.Authenticator(selector, validator);
		Document doc = USER.find(Filters.eq("userID", userID)).first();
		if (doc != null)
			return Doc2User(doc);
		else return null;
>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
	}
	
	public static Document GetUserDocumentByUserID(int userID) {
		FindIterable<Document> cursor = USER.find(Filters.eq("userID", userID));
		Iterator<Document> it = cursor.iterator();
		if (it.hasNext()) {
			return USER.find(Filters.eq("userID", userID)).first();
		} else
			return null;
	}

	public void updateNewPass(String newPass, String username) {
		BasicDBObject query = new BasicDBObject();
		query.put("username", username);

		BasicDBObject newPassDoc = new BasicDBObject();
		newPassDoc.put("password", newPass);

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newPassDoc);

		USER.updateOne(query, updateObject);
	}

	public void updateClipsItem(int userID, int postID) {
		User user = User.GetUserByUserID(userID);

		ArrayList<Integer> listIdPost = new ArrayList<Integer>();
		listIdPost = user.getClips();

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
}

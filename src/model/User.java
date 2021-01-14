package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import x4fit.Utilities;

public class User extends Account {

	private int userID;
	private String fullname;
	private String avatar;
	private String url;
	private String status;
	private List<Integer> follower;
	private List<Integer> following;
	private List<Integer> clips;

	
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
		this.setStatus("ACTIVE");

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
		this.setStatus("ACTIVE");
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
				doc.getString("status"));
	}
	
	public static User DocToUser(Document doc) {
		List<Integer> clips = (List<Integer>) Utilities.convertObjectToList(doc.get("clips"));
		ArrayList<Integer> following = (ArrayList<Integer>) Utilities.convertObjectToList(doc.get("following"));
		ArrayList<Integer> follower = (ArrayList<Integer>) Utilities.convertObjectToList(doc.get("follower"));
		return new User(doc.getInteger("id"), doc.getString("fullname"), doc.getString("avatar"),
				doc.getString("url"), clips, following, follower);
	}

	public static ArrayList<User> getAllUsers1() {
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
	
	public static User Doc2UserFullInfo(Document doc) 
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
		Document cursor = ACCOUNT.find(Filters.eq("email", email)).first();
		if(cursor==null) return null;
		Document doc = USER.find(Filters.eq("id", cursor.getInteger("user_id"))).first();
			return DocToUser(doc);
	}
	

	public static User getUserByUsername(String username) 
	{
		Document doc = ACCOUNT.find(Filters.eq("username", username)).first();
		if (doc!=null)
		{
			int userID = doc.getInteger("user_id");
			Document user = USER.find(Filters.eq("id", userID)).first();
			return DocToUser(user);
		}
		else return null;
	}

	public static User GetUserByUserID(int userID) {
		Document doc = USER.find(Filters.eq("id", userID)).first();
		if (doc == null)
			return null;
		return DocToUser(doc);
	}
	

	public static int GetUserIDFromCookies(Cookie[] cookie) 
	{
		String selector = "", validator = "";
		for (Cookie c : cookie) {
			if (c.getName().equals("selector"))
			{
				selector = c.getValue();
			}
			if (c.getName().equals("validator"))
			{
				validator = c.getValue();
			}	
		}
		int userID = Model.Authenticator(selector, validator);
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

		ACCOUNT.updateOne(query, updateObject);
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
	
	
	public static User convertToUserObject(Document doc) {
		// Convert data từ mongo sang object User
		
		int id = 0;
		String fullname = "";
		
		String avatar = "";
		String url = "";
		
		List<Integer> follower = null;
		List<Integer> following = null;
		List<Integer> clips = null;
		
		if(doc.getInteger("id") != null)
			id = doc.getInteger("id");
		
		if(doc.getString("fullname")!= null)
			fullname = doc.getString("fullname");
		
		
		if(doc.getString("avatar")!= null)
			avatar = doc.getString("avatar");
		
		if(doc.getString("url")!= null)
			url = doc.getString("url");
		
		
		
		if(doc.get("follower")!= null)
			follower = (List<Integer>)doc.get("follower");
		
		if(doc.get("following")!= null)
			following = (List<Integer>)doc.get("following");
		
		if(doc.get("clips")!= null)
			clips = (List<Integer>)doc.get("clips");
		
		return new User( id,  fullname, avatar,  url,  follower,  following,  clips );
				
	}
	
	
	public String getUsername()
	{
		String username = "username";
		
		try
		{
			Account account = Account.GetAccountByUserID(this.userID);
			username = account.getUsername();
		}
		catch(NullPointerException x)
		{
			
		}
		
		return username;
		
	}
	
	public static void createUserByID(int id, String fullname) // Tạo user với user_id đã được tạo ở model account
	{
		Document doc = new Document("_id", new ObjectId());
		
		 List<Integer> follower = new ArrayList<Integer>();
		 List<Integer> following = new ArrayList<Integer>();
		 List<Integer> clips = new ArrayList<Integer>();
		 String status = "ACTIVE";
		
		doc.append("id", id);
		doc.append("fullname", fullname);
		doc.append("avatar", "");
		doc.append("url", "");
		doc.append("status", status);
		doc.append("follower", follower);
		doc.append("following", following);
		doc.append("clips", clips);
		Model.Insert(doc, "USER");
	}
	

	
	
	public List<Post> getBookmarkPost (User user)
	{
		List<Post> posts =new ArrayList<Post>();
		if(user.getClips().size()==0) return null;
		for (int i=0; i<user.getClips().size();i++)
		{
			Post post = new Post();
			posts.add(Post.Doc2Post(post.getPostByIdPost(user.getClips().get(i))));
		}
		return posts;
	}
	
	public List<User> getFollowingUser(User user)
	{
		List<User> users = new ArrayList<User>();
		if(user.getFollowing().size()==0) return null;
		for (int i=0; i<user.getFollowing().size();i++)
		{
			users.add(User.GetUserByUserID(user.getFollowing().get(i)));
		}
		return users;
	}
	
	
	public boolean checkPassword(User user, String password)
	{
		Document doc = Model.ACCOUNT.find(Filters.eq("user_id", user.getUserID())).first();
		if (doc != null) {
			
			String _password_ = doc.getString("password");
			String hashed_password = DigestUtils.sha256Hex(password);
			System.out.print(hashed_password +" AND " +_password_ );
			if (hashed_password.equals(_password_))
			{
				System.out.print("ktra pass thanh congs");
				return true;
			}
			else
				return false;
		} 
		return false;
	}
	
	public List<User> getFollowerUser(User user)
	{
		List<User> users = new ArrayList<User>();
		if(user.getFollower().size()==0) return null;
		for (int i=0; i<user.getFollower().size();i++)
		{
			users.add(User.GetUserByUserID(user.getFollower().get(i)));
		}
		return users;
	}
	
	
	public int countFollowing (User user)
	{
		
		return user.getFollowing().size();
	}
	
	public int countFollower (User user)
	{
		
		return user.getFollower().size();
	}
	
	public int countPost(int idUser)
	{
		int count=0;
		FindIterable<Document> cursor= POST.find(Filters.eq("user_id", idUser));
		Iterator<Document> it = cursor.iterator();
		if (it.hasNext()) {
			
			while (it.hasNext()) {
				count++;
				it.next();
				
			}
		}
		return count;
	}
	
	public int coutTotalPostView (int idUser)
	{
		Post t = new Post();
		int total=0;
		List<Post> posts= t.readAllPersonalPost(idUser);
		for (Post k: posts)
		{
			total+= k.getViews_count();
			
		}
		
		return total;
	}
	
	public int countClips (User user)
	{
		return user.getClips().size();
	}
	
	public static void updateStatus(int id) {
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);

		BasicDBObject newStatusDoc = new BasicDBObject();
		newStatusDoc.put("password", "ACTIVE");

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newStatusDoc);

		USER.updateOne(query, updateObject);
	}
	
	public boolean updateInforUser(int iduser,String fullname, String email, String username,String password)
	{
		
		UpdateResult result1;
		UpdateResult result2;
		if(password=="")
		{
			result1=USER.updateOne(Filters.eq("id", iduser), Updates.combine(Updates.set("fullname",fullname )));
			result2= ACCOUNT.updateOne(Filters.eq("user_id", iduser),Updates.combine(Updates.set("email", email),
																			Updates.set("username",username)));
			
		}
		else
		{
			String hashed_password = DigestUtils.sha256Hex(password);
			
			result1= USER.updateOne(Filters.eq("id", iduser), Updates.combine(Updates.set("fullname",fullname )));
			
			result2= ACCOUNT.updateOne(Filters.eq("user_id", iduser),Updates.combine(Updates.set("email", email),
																			Updates.set("username",username),
																			Updates.set("password", hashed_password)));
			
		}
		if(result1.getModifiedCount()<=0 || result2.getModifiedCount()<=0)
			return false;
		return true;
	}
	
	public static void updateUserStatus(int userId, String newStatus) {
		USER.updateOne(Filters.eq("id", userId), Updates.set("status", newStatus));
	}
}

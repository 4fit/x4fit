package model;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;

import javax.print.Doc;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.Updates;
import x4fit.Utilities;


public class User extends Model {
	
	
	private int userID;
	private String fullname;
	private String avatar;
	private String url;

	private List<Integer> follower;
	private List<Integer> following;
	private List<Integer> clips;
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
	public User(String username, String pass, String email ) {
		
		
//		this.setClips_count(0);
//		this.setFollower_count(0);
//		this.setFollowing_count(0);
//		this.setPostsCount(0);
//		this.setName("");
//		this.setAvata("");
		ArrayList<Integer> follow  = new ArrayList<Integer>(); // set số lượng follow
		this.setFollower(follow);
		this.setFollowing(follow);
		this.setClips(follow);
		//System.out.print("Da toi luc tao nhan viên");
		

		this.userID= getLastestID("User")+1;

	}
	
public User(String name, String username, String pass, String email ) {
		
		this.fullname = name;
//		this.setClips_count(0);
//		this.setFollower_count(0);
//		this.setFollowing_count(0);
//		this.setPostsCount(0);
//		this.setAvata("");
		ArrayList<Integer> follow  = new ArrayList<Integer>(); // set số lượng follow
		this.setFollower(follow);
		this.setFollowing(follow);
		this.setClips(follow);
		//System.out.print("Da toi luc tao nhan viên");
		

		this.userID=(int) getLastestID("USER")+1;

	
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
	
	public String getEmail(int userID)
	{
		return Account.GetAccountByUserID(userID).getEmail();
	}

	public String getUsername(int userID)
	{
		return Account.GetAccountByUserID(userID).getUsername();
	}
	public User() {

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
		this.setStatus("ACTIVE");
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
//
//<<<<<<< HEAD
//
//	public void addFollowingForIdUser(int idUserMain, int idUserFollow) // idUserMain là user sẽ được user đang đăng
//																		// nhâp follow (idUserFollow)
//	{
//		updateFollow("following", idUserFollow, idUserMain);
//		updateCount("following_count", idUserFollow);
//
//		updateFollow("follower", idUserMain, idUserFollow);
//		updateCount("follower_count", idUserMain);
//
//	}
//

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
			System.out.print("ko null");
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
	
	
	public void updateInforUser(int iduser,String fullname, String email, String username,String password)
	{
		if(password!="")
		{
			USER.updateOne(Filters.eq("id", iduser), Updates.combine(Updates.set("fullname",fullname )));
			ACCOUNT.updateOne(Filters.eq("user_id", iduser),Updates.combine(Updates.set("email", email),
																			Updates.set("username",username)));
			
		}
		else
		{
			String hashed_password = DigestUtils.sha256Hex(password);

			USER.updateOne(Filters.eq("id", iduser), Updates.combine(Updates.set("fullname",fullname )));
			ACCOUNT.updateOne(Filters.eq("user_id", iduser),Updates.combine(Updates.set("email", email),
																			Updates.set("username",username)));
			updateNewPass(username,hashed_password);		
		}
		
	}
	
}

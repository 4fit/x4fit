package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Gallery extends Model
{
	private int ID;
	private int userID;
	private User user; //bỏ
	private List<String> images;
	private List<Integer> follower;
	private List<Integer> following;
	private List<Integer> clips;
	private String strImages;
	private String strFollowers;
	private String strFollowings;
	private String strClips;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
		StringBuilder sb = new StringBuilder();
		for (String img : images) {
			sb.append(img).append("|");
		}
		this.strImages = sb.toString();
	}

	public List<Integer> getFollower() {
		return follower;
	}

	public void setFollower(List<Integer> follower) {
		this.follower = follower;
		StringBuilder sb = new StringBuilder();
		for (Integer x : follower) {
			sb.append(x.toString()).append("|");
		}
		this.strImages = sb.toString();
	}

	public List<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(List<Integer> following) {
		this.following = following;
		StringBuilder sb = new StringBuilder();
		for (Integer x : following) {
			sb.append(x.toString()).append("|");
		}
		this.strImages = sb.toString();
	}

	public List<Integer> getClips() {
		return clips;
	}

	public void setClips(List<Integer> clips) {
		this.clips = clips;
		StringBuilder sb = new StringBuilder();
		for (Integer x : clips) {
			sb.append(x.toString()).append("|");
		}
		this.strImages = sb.toString();
	}

	public Gallery() {}
	
	@SuppressWarnings("unchecked")
	public Gallery(int id, User user, Object images, Object follower, Object following, Object clips)
	{
		this.setID(id);
		this.setUser(user);
		List<String> imgs = (List<String>) x4fit.Utilities.convertObjectToList(images);
		this.setImages(imgs);
		List<Integer> followers = (List<Integer>) x4fit.Utilities.convertObjectToList(follower);
		this.setFollower(followers);
		List<Integer> followings = (List<Integer>) x4fit.Utilities.convertObjectToList(following);
		this.setFollowing(followings);
		List<Integer> posts = (List<Integer>) x4fit.Utilities.convertObjectToList(clips);
		this.setClips(posts);
	}
	
	public Gallery(int userID)
	{
		this.setID(Model.getLastestID(GALLERY)+1);
		this.setUserID(userID);
	}
	
//	public void updateClipsItem(int userID, int postID) 
//	{
//
//		int[] clips = user.getClips();
//		List<Integer> listPostID = Arrays.stream(clips).boxed().collect(Collectors.toList());
//		
//		if (isExitInArray(listPostID, postID) == 0) {
//			listPostID.add(postID);
//
//			BasicDBObject query = new BasicDBObject();
//			query.put("id", userID);
//
//			BasicDBObject newList = new BasicDBObject();
//			newList.put("clips", listPostID.toArray());
//
//			BasicDBObject updateObject = new BasicDBObject();
//			updateObject.put("$set", newList);
//
//			//USER = db.getCollection("USER");
//			USER.updateOne(query, updateObject);
//		}
//	}
	
	public static void Update()
	{
		
	}
	
	public static Gallery GetGallery(int userID)
	{
		Document doc = Model.GALLERY.find(Filters.eq("user", userID)).first();
		if (doc != null)
			return Doc2Gallary(doc);
		return null;
	}
	
	public static Gallery Doc2Gallary(Document doc)
	{
		return new Gallery(
				doc.getInteger("id"),
				(User)doc.get("user"),
				doc.get("images"),
				doc.get("follower"),
				doc.get("following"),
				doc.get("clips")
				);
	}
	
	public void Insert()
	{
		List<String> empty = Arrays.asList();
		List<Integer> emp = Arrays.asList();
		Document doc = new Document("id", this.getID())
				.append("userID", this.getUserID())
				.append("images", empty)
				.append("following", emp)
				.append("follower", emp)
				.append("clips", emp);
		GALLERY.insertOne(doc);
	}
	public static void InsertImage(int id, String fileName, int userID, String filePath)
	{
		GALLERY.findOneAndUpdate(Filters.eq("userID", userID), Updates.addToSet("images", filePath));
//		Document doc = new Document("id", id)
//				.append("fileName", fileName)
//				.append("userID", userID)
//				.append("filePath", filePath);
//		Model.Insert(doc, Model.GALLERY);
	}
}

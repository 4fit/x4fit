package model;

import java.util.List;

import org.bson.Document;
import com.mongodb.client.model.Filters;

public class Gallery extends Model
{
	private int ID;
	private User user;
	private List<String> images;
	private List<Integer> follower;
	private List<Integer> following;
	private List<Integer> clips;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
		Document doc = GALLERY.find(Filters.eq("userID", userID)).first();
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
}

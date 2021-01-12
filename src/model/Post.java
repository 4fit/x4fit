package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import x4fit.Utilities;


public class Post extends Model {
	private int id;
	private String title;
	private int user_id;
	private String url;
	private String content;
	private String published_at;
	private String updated_at;
	private int views_count;
	private int points;
	private int clips_count;
	private boolean is_public;
	private String thumbnail_url;
	private String status;
	private String category;
	private List<Integer> upvote;	// chứa DS userID đã upvote cho bài viết
	private List<Integer> downvote;	// chứa DS userID đã downvote cho bài viết
	private List<Integer> clips;	// chứa DS userID đã ghim bài viết

	public List<Integer> getClips() {
		return clips;
	}
	public void setClips(List<Integer> clips) {
		this.clips = clips;
	}
	public List<Integer> getUpvote() {
		return upvote;
	}
	public void setUpvote(List<Integer> upvote) {
		this.upvote = upvote;
	}
	public List<Integer> getDownvote() {
		return downvote;
	}

	public void setDownvote(List<Integer> downvote) {
		this.downvote = downvote;
	}

	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getURL() {
		return url;
	}
	public void setURL(String p) {
		this.url = p;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getPublished_at() {
		return published_at;
	}
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getViews_count() {
		return views_count;
	}
	public void setViews_count(int views_count) {
		this.views_count = views_count;
	}

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	public int getClips_count() {
		return clips_count;
	}
	public void setClips_count(int clips_count) {
		this.clips_count = clips_count;
	}

	public boolean getIs_public() {
		return is_public;
	}
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Post() {
	}


	public Post(String title, int user_id, String content, boolean is_public, String thumbnail_url, String category) 
	{
		this.id = getPostID();
		this.title = title;
		this.user_id = user_id;
		this.url = Utilities.createURL(title);
		this.content = content;
		this.published_at = this.updated_at = Utilities.GetCurrentDateTime();
		this.views_count = 0;
		this.points = 0;
		this.is_public = is_public;
		this.thumbnail_url = thumbnail_url;
		this.category = category;
		this.status = "Chờ duyệt";
	}

	public Post(int id, String title, int user_id, String p, String content, String published_at, String updated_at,
			boolean is_public, int views_count, int points, String thumbnail_url, String category, String status) {
		this.id = id;
		this.title = title;
		this.user_id = user_id;
		this.url = p;
		this.content = content;
		this.published_at = published_at;
		this.updated_at = updated_at;
		this.views_count = views_count;
		this.points = points;
		this.is_public = is_public;
		this.thumbnail_url = thumbnail_url;
		this.category = category;
		this.status = status;
	}
	
	// Duyệt bài post
	public static boolean acceptPost(int postId) {
		try {
			POST.updateOne(Filters.eq("id", postId), new Document("$set", new Document("status", "Đã duyệt")));
			System.out.println("Accepted post!");
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public ArrayList<Comment> GetAllComments() {
		FindIterable<Document> cursor = CMT.find(Filters.eq("postID", this.getID()));
		Iterator<Document> it = cursor.iterator();
		ArrayList<Comment> listComments = new ArrayList<Comment>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				Comment cmt = Comment.Doc2Cmt(doc);
				listComments.add(cmt);
			}
		}
		return listComments;
	}

	public static int getPostID() {
		return getLastestID(POST) + 1;
	}

	public static List<Post> getAllPosts() {
		FindIterable<Document> cursor = POST.find();
		Iterator<Document> it = cursor.iterator();
		List<Post> data = new ArrayList<Post>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				Post post = Doc2Post(doc);
				data.add(post);
			}
		}
		return data;
	}

	public static void Insert(Post p) {
		Insert( p.getID(), 
				p.getTitle(), 
				p.getUser_id(), 
				p.getURL(), 
				p.getContent(), 
				p.getPublished_at(), 
				p.getIs_public(),
				p.getViews_count(), 
				p.getPoints(), 
				p.getThumbnail_url(), 
				p.getCategory());
	}

	public static void Insert(int id, String title, int user_id, String p, String content, String published_at,
			boolean is_public, int views_count, int points, String thumbnail_url, String category) 
	{
		List<Integer> empty = Arrays.asList();
		Document doc = new Document("id", id)
				.append("title", title)
				.append("user_id", user_id)
				.append("url", p)
				.append("content", content)
				.append("published_at", published_at)
				.append("updated_at", published_at)
				.append("views_count", views_count)
				.append("points", points)
				.append("is_public", is_public)
				.append("thumbnail_url", thumbnail_url)
				.append("status", "Chờ duyệt")
				.append("upvote", empty)
				.append("downvote", empty)
				.append("clips", empty);
		Insert(doc, POST);
	}

	public static Post GetPost(String p) {
		Document doc = POST.find(Filters.eq("url", p)).first();
		if (doc == null)
			return null;
		try {
			return Doc2Post(doc);
		} catch (Exception e) {

		}
		return null;
	}

	public static Post Doc2Post(Document doc) {
		return new Post(
				doc.getInteger("id"), 
				doc.getString("title"), 
				doc.getInteger("user_id"), 
				doc.getString("url"),
				doc.getString("content"), 
				doc.getString("published_at"), 
				doc.getString("updated_at"),
				doc.getBoolean("is_public"), 
				doc.getInteger("views_count"), 
				doc.getInteger("points"), 
				doc.getString("thumbnail_url"), 
				doc.getString("category"),
				doc.getString("status")
				);
	}
	
	public static ArrayList<Post> GetLastestPost(int lim)
	{
		FindIterable<Document> cursor = POST.find().sort(new BasicDBObject("id", -1)).limit(lim);
		Iterator<Document> it = cursor.iterator();
		ArrayList<Post> topPost = new ArrayList<Post>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				Post p = Doc2Post(doc);
				topPost.add(p);
			}
		}
		return topPost;
	}

	// Lấy tất cả các bài postController của một user
	// Truyền vào user id

	public List<Post> readAllPersonalPost(int iduser) {
		FindIterable<Document> cursor = POST.find(new BasicDBObject("user_id", iduser));
		Iterator<Document> it = cursor.iterator();
		List<Post> data = new ArrayList<Post>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				Post p = Doc2Post(doc);
				data.add(p);
			}
		}
		return data;
	}

	public static String Update(String p, String title, String new_title, String content, 
			boolean is_public, String thumbnail_url, String category) {
		
		String newURL = p;
		if (!new_title.equals(title))
			newURL = Utilities.createURL(title);
		POST.updateOne(Filters.eq("url", p),
				Updates.combine(Updates.set("url", newURL), 
						Updates.set("title", title), 
						Updates.set("content", content),
						Updates.set("category", category), 
						Updates.set("is_public", is_public),
						Updates.set("updated_at", Utilities.GetCurrentDateTime()),
						Updates.set("thumbnail_url", thumbnail_url)));
		return newURL;
		
	}

	public void updateVote(String nameField, int idPost, int idUserVote) // Bao gồm upvote, downvote
	{
		Document post = getPostByIdPost(idPost);
		// System.out.print(postController.get(nameField));
		List<Integer> vote = (ArrayList<Integer>) post.get(nameField);
		if (isExitInArray(vote, idUserVote) == 0) // Kiểm tra xem user đó đã thực hiện vote chưa, nếu có thì không cần
													// update
		{
			vote.add(idUserVote);

			BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh
			query.put("id", idPost);

			BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách follow
			newList.put(nameField, vote);

			BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update follow
			updateObject.put("$set", newList);

			POST.updateOne(query, updateObject);

		}
	}

	public Document getPostByIdPost(int idPost) {
		return POST.find(Filters.eq("id", idPost)).first();
	}

	public void updateItem(String nameField, int user_id, int post_id) {
		Document postDoc = new Document();
		postDoc = this.getPostByIdPost(post_id);

		List<Integer> listIdPost = new ArrayList<Integer>();
		listIdPost = (ArrayList) postDoc.get(nameField);

		if (isExitInArray(listIdPost, user_id) == 0) {
			listIdPost.add(user_id);

			BasicDBObject query = new BasicDBObject();
			query.put("id", post_id);

			BasicDBObject newList = new BasicDBObject();
			newList.put("clips", listIdPost);

			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", newList);

			POST.updateOne(query, updateObject);

			updateCount("clips_count", post_id);
		}
	}

	public List<Post> getPostOfUser(int idUser) {
		List<Post> lPost = new ArrayList<Post>();
		FindIterable<Document> listPost = POST.find(Filters.eq("user_id", idUser));
		Iterator<Document> list = listPost.iterator();
		while (list.hasNext()) {
			lPost.add(Doc2Post(list.next()));
		}

		return lPost;
	}

	public void updateCount(String nameField, int idMain) {
		Document post = this.getPostByIdPost(idMain);
		int count = post.getInteger(nameField) + 1;

		BasicDBObject query = new BasicDBObject(); // Lệnh query để so sánh
		query.put("id", idMain);

		BasicDBObject newList = new BasicDBObject(); // Tạo mới danh sách count clip trong postController
		newList.put(nameField, count);

		BasicDBObject updateObject = new BasicDBObject(); // thực hiện lệnh $set để update count_clips
		updateObject.put("$set", newList);

		POST.updateOne(query, updateObject);
	}

	public int countComment(int post_id) {
		FindIterable<Document> listCMT = CMT.find(Filters.eq("post_id", post_id));
		Iterator<Document> lCMT = listCMT.iterator();

		int count = 0;
		while (lCMT.hasNext()) {
			lCMT.next();
			count++;
		}
		return count;
	}
	
	public static void InsertUpvote(String url, int userID)
	{
		POST.findOneAndUpdate(
				Filters.eq("url", url), 
				Updates.combine(
						Updates.addToSet("upvote", userID), 
						Updates.inc("points", 1)
						)
				);

	}
	
	public static void InsertDownvote(String url, int userID)
	{
		POST.findOneAndUpdate(
				Filters.eq("url", url), 
				Updates.combine(
						Updates.addToSet("downvote", userID), 
						Updates.inc("points", -1)
						)
				);
		
	}
	
	public static void InsertClips(String url, int userID)
	{
		POST.findOneAndUpdate(Filters.eq("url", url), Updates.addToSet("clips", userID));
	}
	
	@SuppressWarnings("unchecked")
	public static int GetClipsCount(String url)
	{
		Document doc = POST.find(Filters.eq("url", url)).first();
		try
		{
			List<Integer> clips = (List<Integer>) Utilities.convertObjectToList(doc.get("clips"));
			return clips.size();
		}
		catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}

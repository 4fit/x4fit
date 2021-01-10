package model;
import dao.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import x4fit.Utilities;

//http://mongodb.github.io/mongo-java-driver/3.4/javadoc/com/mongodb/client/model/Updates.html

public class Post extends Model {
	private int id;
	private String title;
	private int user_id;
	private String p;
	private String content;
	private String published_at;
	private String updated_at;
	private int views_count;
	private int points;
	private int clips_count;
	private boolean is_public;
	private String thumbnail_url;
	private String category;
	private int[] upvote;
	private int[] downvote;
	private int[] clips;

	public int[] getClips() {
		return clips;
	}
	public void setClips(int[] clips) {
		this.clips = clips;
	}

	public int[] getUpvote() {
		return upvote;
	}
	public void setUpvote(int[] upvote) {
		this.upvote = upvote;
	}

	public int[] getDownvote() {
		return downvote;
	}
<<<<<<< HEAD
	

=======
>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
	public void setDownvote(int[] downvote) {
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

	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
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

	public Post() {
	}

<<<<<<< HEAD
	public DAO getDB() {
		return db;
	}

	public void setdb(DAO db) {
		this.db = db;
	}
	


	public void allowPost() {
		this.allow_post = true;
	}

	public int count_cmt()
	{
		DetailPostDAO db = new DetailPostDAO();
		return db.countComment(this.getID());
		
	}
	
	public int count_vote()
	{
		if(this.upvote!= null)
			return this.upvote.length;
		else return 0;
	}
	
	public Post()
	{
		this.id = 0;
		this.title = "";
		this.user_id = 0;
		this.p = Utilities.GetCurrentDateTime();
		this.content = "";
		this.published_at = "";
		this.views_count = 0;
		this.points = 0;
		this.clips_count = 0;
		this.is_public = false;
		this.thumbnail_url = "";
		this.tags = "";
		this.user = new Document();
		this.upvote = new int[] {}; //bảng upvote
		this.downvote = new int[] {}; // bảng downvote
		this.clips = new int[] {}; // bảng clips
		
		this.allow_post = false;
	}
	
	public Post(String title, int user_id, String content, boolean is_public, 
			String thumbnail_url, String tags)
	{
		this.id = PostDAO.getPostID();
=======
	public Post(String title, int user_id, String content, boolean is_public, String thumbnail_url, String category) {
		this.id = getPostID();
>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
		this.title = title;
		this.user_id = user_id;
		this.p = Utilities.createURL(title);
		this.content = content;
		this.published_at = this.updated_at = Utilities.GetCurrentDateTime();
		this.views_count = 0;
		this.points = 0;
		this.clips_count = 0;
		this.is_public = is_public;
		this.thumbnail_url = thumbnail_url;
		this.category = category;
	}

	public Post(int id, String title, int user_id, String p, String content, String published_at, String updated_at,
			boolean is_public, int views_count, int points, int clips_count, String thumbnail_url, String category) {
		this.id = id;
		this.title = title;
		this.user_id = user_id;
		this.p = p;
		this.content = content;
		this.published_at = published_at;
		this.updated_at = updated_at;
		this.views_count = views_count;
		this.points = points;
		this.clips_count = clips_count;
		this.is_public = is_public;
		this.thumbnail_url = thumbnail_url;
		this.category = category;
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
		System.out.println(listComments.size());
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
		Insert(p.getID(), p.getTitle(), p.getUser_id(), p.getP(), p.getContent(), p.getPublished_at(), p.getIs_public(),
				p.getViews_count(), p.getPoints(), p.getClips_count(), p.getThumbnail_url(), p.getCategory());
	}

	public static void Insert(int id, String title, int user_id, String p, String content, String published_at,
			boolean is_public, int views_count, int points, int clips_count, String thumbnail_url, String tags) {
		Document doc = new Document("id", id).append("title", title).append("user_id", user_id).append("p", p)
				.append("content", content).append("published_at", published_at).append("updated_at", published_at)
				.append("views_count", views_count).append("points", points).append("clips_count", clips_count)
				.append("is_public", is_public).append("thumbnail_url", thumbnail_url);
		Insert(doc, POST);
	}

	public static void allowPost(int postId) {
		try {
			POST.updateOne(Filters.eq("id", postId), new Document("$set", new Document("allow_post", true)));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static Post GetPost(String p) {
		Document doc = POST.find(Filters.eq("p", p)).first();
		if (doc == null)
			return null;
		Post post = new Post();
		try {
			post = Doc2Post(doc);
		} catch (Exception e) {

		}
		return post;
	}

	public static Post Doc2Post(Document doc) {
		return new Post(doc.getInteger("id"), doc.getString("title"), doc.getInteger("user_id"), doc.getString("p"),
				doc.getString("content"), doc.getString("published_at"), doc.getString("updated_at"),
				doc.getBoolean("is_public"), doc.getInteger("views_count"), doc.getInteger("points"),
				doc.getInteger("clips_count"), doc.getString("thumbnail_url"), doc.getString("category")
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

	public static String Update(String p, String title, String content, boolean is_public, String thumbnail_url,
			String tags) {
		String newURL = Utilities.createURL(title);
		POST.updateOne(Filters.eq("p", p),
				Updates.combine(Updates.set("p", newURL), Updates.set("title", title), Updates.set("content", content),
						Updates.set("category", tags), Updates.set("is_public", is_public),
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

//	public void updateClipsCountOfPost(int idPost, int clipsCount)
//	{
//		BasicDBObject query  = new BasicDBObject();
//		query.put("post_id", idPost);
//		BasicDBObject newClipsDoc = new BasicDBObject();
//		newClipsDoc.put("clips_count", clipsCount);
//		BasicDBObject updateObject = new BasicDBObject();
//		updateObject.put("$set", newClipsDoc);
//		MongoCollection<Document> collection =  DAO.db.getCollection("POST");
//		collection.updateOne(query, updateObject);
//	}

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
}

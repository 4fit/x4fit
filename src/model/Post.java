package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import x4fit.Utilities;

public class Post
{
	private int p_id;
	private String p_title;
	private String p_user_id;
	private String p;
	private String p_content;
	private String p_published_at;
	private String p_updated_at;
	private int p_views_count;
	private int p_points;
	private int p_clips_count;
	private boolean p_is_public;
	private String p_thumbnail_url;
	private String p_tags;
	private Document p_user;
	private DB_conn p_db;
	private String p_author;
	
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(String p_user_id) {
		this.p_user_id = p_user_id;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_published_at() {
		return p_published_at;
	}

	public void setP_published_at(String p_published_at) {
		this.p_published_at = p_published_at;
	}

	public String getP_updated_at() {
		return p_updated_at;
	}

	public void setP_updated_at(String p_updated_at) {
		this.p_updated_at = p_updated_at;
	}
	
	public int getP_views_count() {
		return p_views_count;
	}

	public void setP_views_count(int p_views_count) {
		this.p_views_count = p_views_count;
	}

	public int getP_points() {
		return p_points;
	}

	public void setP_points(int p_points) {
		this.p_points = p_points;
	}

	public int getP_clips_count() {
		return p_clips_count;
	}

	public void setP_clips_count(int p_clips_count) {
		this.p_clips_count = p_clips_count;
	}

	public boolean isP_is_public() {
		return p_is_public;
	}

	public void setP_is_public(boolean p_is_public) {
		this.p_is_public = p_is_public;
	}

	public String getP_thumbnail_url() {
		return p_thumbnail_url;
	}

	public void setP_thumbnail_url(String p_thumbnail_url) {
		this.p_thumbnail_url = p_thumbnail_url;
	}

	public String getP_tags() {
		return p_tags;
	}

	public void setP_tags(String p_tags) {
		this.p_tags = p_tags;
	}

	public Document getP_user() {
		return p_user;
	}

	public void setP_user(Document p_user) {
		this.p_user = p_user;
	}

	public DB_conn getP_db() {
		return p_db;
	}

	public void setP_db(DB_conn p_db) {
		this.p_db = p_db;
	}
	
	public Post()
	{
		this.p_id = 0;
		this.p_title = "";
		this.p_user_id = "";
		this.p = Utilities.GetCurrentDateTime();
		this.p_content = "";
		this.p_published_at = "";
		this.p_views_count = 0;
		this.p_points = 0;
		this.p_clips_count = 0;
		this.p_is_public = false;
		this.p_thumbnail_url = "";
		this.p_tags = "";
		this.p_user = new Document();
	}
	
	public Post(String title, String user_id, String content, boolean is_public, 
			String thumbnail_url, String tags)
	{
		this.p_id = getPostID();
		this.p_title = title;
		this.p_user_id = user_id;
		this.p = Utilities.removeAccent(title).replaceAll("\\W", "-") + "-" + Utilities.GetHash();
		this.p_content = content;
		this.p_published_at = Utilities.GetCurrentDateTime();
		this.p_views_count = 0;
		this.p_points = 0;
		this.p_clips_count = 0;
		this.p_is_public = is_public;
		this.p_thumbnail_url = thumbnail_url;
		this.p_tags = tags;
		this.p_user = new User().getUserInfo(user_id);
	}
	
	public Post(int id, String title, String user_id, String p, String content,
			String published_at, String updated_at, boolean is_public, int views_count, int points, 
			int clips_count, String thumbnail_url, String tags, Document user)
	{
		this.p_id = id;
		this.p_title = title;
		this.p_user_id = user_id;
		this.p = p;
		this.p_content = content;
		this.p_published_at = published_at;
		this.p_updated_at = updated_at;
		this.p_views_count = views_count;
		this.p_points = points;
		this.p_clips_count = clips_count;
		this.p_is_public = is_public;
		this.p_thumbnail_url = thumbnail_url;
		this.p_tags = tags;
		this.p_user = user;
	}
	
	public int getPostID()
	{
		return DB_conn.getLastestID("POST") + 1;
	}
	
	public void Insert_Post()
	{
		Insert_Post(this.p_id, this.p_title, this.p_user_id, this.p, this.p_content,
					this.p_published_at, this.p_is_public, this.p_views_count, this.p_points, 
					this.p_clips_count, this.p_thumbnail_url, this.p_tags, this.p_user);
	}
	
	public void Insert_Post(int id, String title, String user_id, String p, String content,
							String published_at, boolean is_public, int views_count, int points, 
							int clips_count, String thumbnail_url, String tags, Document user)
	{
		Document doc = new Document("id", id)
							.append("title", title)
							.append("user_id", user_id)
							.append("p", p)
							.append("content", content)
							.append("published_at", published_at)
							.append("updated_at", published_at)
							.append("views_count", views_count)
							.append("points", points)
							.append("clips_count", clips_count)
							.append("is_public", is_public)
							.append("thumbnail_url", thumbnail_url)
							.append("user", user);
		DB_conn.Insert(doc, "POST");
	}
	
	public static Post GetPost(String p)
	{
		MongoCollection<Document> collection = DB_conn.database.getCollection("POST");
		Document doc = collection.find(Filters.eq("p", p))
								 .first();
		if (doc == null)
			return new Post();
		Post post = new Post();
		try
		{
			post = new Post(doc.getInteger("id"),
							  doc.getString("title"),
							  doc.getString("user_id"),
							  p,
							  doc.getString("content"),
							  doc.getString("published_at"),
							  doc.getString("updated_at"),
							  doc.getBoolean("is_public"),
							  doc.getInteger("views_count"),
							  doc.getInteger("points"),
							  doc.getInteger("clips_count"),
							  doc.getString("thumbnail_url"),
							  doc.getString("tags"),
							  (Document) doc.get("user")
							  );
		}
		catch (Exception e) {
			
		}
		return post;
	}
	
	public Post ConverseToPost(Document doc)
	{
		Post p = new Post();
		p.setP_content((String) doc.get("content"));;
		p.setP_id(Integer.parseInt( doc.get("id").toString()));
		p.setP_title((String) doc.get("title"));
		if(doc.get("published_at")!=null)
		p.setP_published_at(doc.get("published_at").toString());
		p.setP_clips_count(Integer.parseInt(doc.get("clips_count").toString()));
		p.setP_views_count(Integer.parseInt(doc.get("views_count").toString()));
		p.setP_user_id(doc.get("user_id").toString());		
		return p;
	}
	
	//Lấy tất cả các bài post của một user
	//Truyền vào user id
	
	public List<Post> readAllPersonalPost(int iduser) {
		
		MongoCollection<Document> collection = DB_conn.database.getCollection("POST");
		//DBCollection  col = (DBCollection) database.getCollection("POST");
		FindIterable<Document> cursor = collection.find(new BasicDBObject("user_id",iduser));		
		Iterator<Document> it = cursor.iterator();
		List<Post> data = new ArrayList<Post>();	
		if(it.hasNext())
		{		
			while (it.hasNext()) {
				Document doc = it.next();
				Post p = ConverseToPost(doc);
				data.add(p);
			}
		}
		return data;
	
	}
		
	private MongoClient getMongoClient() {
		// TODO Auto-generated method stub
		return null;
	}
}

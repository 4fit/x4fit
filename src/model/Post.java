package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class Post extends DB_conn
{
	private int p_id;
	private String p_title;
	private String p_user_id;
	private String p_transliterated;
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

	public String getP_transliterated() {
		return p_transliterated;
	}

	public void setP_transliterated(String p_transliterated) {
		this.p_transliterated = p_transliterated;
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
		this.p_transliterated = "";
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
		//published_at
		LocalDateTime currentDateTime = java.time.LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String published_at = currentDateTime.format(formatter);
		
		this.p_id = getPostID();
		this.p_title = title;
		this.p_user_id = user_id;
		this.p_transliterated = x4fit.Utilities.removeAccent(title);
		this.p_content = content;
		this.p_published_at = published_at;
		this.p_views_count = 0;
		this.p_points = 0;
		this.p_clips_count = 0;
		this.p_is_public = is_public;
		this.p_thumbnail_url = thumbnail_url;
		this.p_tags = tags;
		this.p_user = new User().getUserInfo(user_id);
	}
	
	public Post(int id, String title, String user_id, String transliterated, String content,
			String published_at, String updated_at, boolean is_public, int views_count, int points, 
			int clips_count, String thumbnail_url, String tags, Document user)
	{
		this.p_id = id;
		this.p_title = title;
		this.p_user_id = user_id;
		this.p_transliterated = transliterated;
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
		return super.getLastestID("POST") + 1;
	}
	
	public void Insert_Post()
	{
		Insert_Post(this.p_id, this.p_title, this.p_user_id, this.p_transliterated,this.p_content,
					this.p_published_at, this.p_is_public, this.p_views_count, this.p_points, 
					this.p_clips_count, this.p_thumbnail_url, this.p_tags, this.p_user);
	}
	
	public void Insert_Post(int id, String title, String user_id, String transliterated, String content,
							String published_at, boolean is_public, int views_count, int points, 
							int clips_count, String thumbnail_url, String tags, Document user)
	{
		Document doc = new Document("id", id)
							.append("title", title)
							.append("user_id", user_id)
							.append("transliterated", transliterated)
							.append("content", content)
							.append("published_at", published_at)
							.append("updated_at", published_at)
							.append("views_count", views_count)
							.append("points", points)
							.append("clips_count", clips_count)
							.append("is_public", is_public)
							.append("thumbnail_url", thumbnail_url)
							.append("user", user);
		Insert(doc, "POST");
	}
	
	public static Post GetPost(String post_id)
	{
		int id = Integer.parseInt(post_id);
		MongoCollection<Document> collection = database.getCollection("POST");
		Document doc = collection.find(Filters.eq("id", id))
								 .first();
		Post p = new Post(id,
						  doc.getString("title"),
						  doc.getString("user_id"),
						  doc.getString("transliterated"),
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
		return p;
	}
}

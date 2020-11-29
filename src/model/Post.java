package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

public class Post extends DB_conn
{
	public int p_id;
	public String p_title;
	public String p_user_id;
	public String p_transliterated;
	public String p_content;
	public String p_published_at;
	public int p_views_count;
	public int p_points;
	public int p_clips_count;
	public boolean p_is_public;
	public String p_thumbnail_url;
	public String p_tags;
	public Document p_user;
	private DB_conn p_db;
	
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
	
	public Post(String title, String user_id, String content, boolean is_public, String thumbnail_url, String tags)
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
}

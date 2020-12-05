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
	private int id;
	private String title;
	private String user_id;
	private String p;
	private String content;
	private String published_at;
	private String updated_at;
	private int views_count;
	private int points;
	private int clips_count;
	private boolean is_public;
	private String thumbnail_url;
	private String tags;
	private Document user;
	private DAO db;
	
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Document getUser() {
		return user;
	}

	public void setUser(Document user) {
		this.user = user;
	}

	public DAO getDB() {
		return db;
	}

	public void setdb(DAO db) {
		this.db = db;
	}
	
	public Post()
	{
		this.id = 0;
		this.title = "";
		this.user_id = "";
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
	}
	
	public Post(String title, String user_id, String content, boolean is_public, 
			String thumbnail_url, String tags)
	{
		this.id = PostDAO.getPostID();
		this.title = title;
		this.user_id = user_id;
		String plaintText = Utilities.removeAccent(title).replaceAll("\\W", "-");
		String tmp = plaintText.replace("-", "")+"A";
		if (tmp.equals("A"))
			this.p = Utilities.GetHash();
		else
			this.p = plaintText + "-" + Utilities.GetHash();
		this.content = content;
		this.published_at = Utilities.GetCurrentDateTime();
		this.views_count = 0;
		this.points = 0;
		this.clips_count = 0;
		this.is_public = is_public;
		this.thumbnail_url = thumbnail_url;
		this.tags = tags;
		this.user = UserDAO.getUserInfo(user_id);
	}
	
	public Post(int id, String title, String user_id, String p, String content,
			String published_at, String updated_at, boolean is_public, int views_count, int points, 
			int clips_count, String thumbnail_url, String tags, Document user)
	{
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
		this.tags = tags;
		this.user = user;
	}
}

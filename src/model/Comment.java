package model;

import org.bson.Document;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import x4fit.Utilities;

public class Comment extends Model
{
	private int id;
	private int userID ;
	private int postID ;
	private int level;
	private int points;
	private int reply_cmtID;
	private int reply_userID;
	private String created_at;
	private String updated_at;
	private String content;
	private String status;

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReply_cmtID() {
		return reply_cmtID;
	}


	public void setReply_cmtID(int reply_cmtID) {
		this.reply_cmtID = reply_cmtID;
	}


	public int getReply_userID() {
		return reply_userID;
	}


	public void setReply_userID(int reply_userID) {
		this.reply_userID = reply_userID;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Comment()
	{
		
	}
	
	public Comment(int userID, int postID, String content) {
		this(getLastestID(CMT) + 1,
			 userID, 
			 postID, 
			 1, 	//level
			 0, 	//points
			 0, 	//reply_cmtID
			 0, 	//reply_userID
			 Utilities.GetCurrentDateTime(), 
			 "", 	//updated_at
			 content,
			 "OK"	//status
			 );
	}
	
	public Comment(int id, int userID, int postID, int level, int points, int reply_cmtID,
			int reply_userID, String created_at, String updated_at, String content, String status) {
		this.setPostID(postID);
		this.setID(id);
		this.setUserID(userID);
		this.setLevel(level);
		this.setPoints(points);
		this.setReply_cmtID(reply_cmtID);
		this.setReply_userID(reply_userID);
		this.setCreated_at(created_at);
		this.setUpdated_at(updated_at);
		this.setContent(content);
		this.setStatus(status);
	}
	
	public void Insert()
	{
		Insert(this.getID(), 
			   this.getUserID(), 
			   this.getPostID(),
			   this.getLevel(),
			   this.getPoints(),
			   this.getReply_cmtID(), 
			   this.getReply_userID(), 
			   this.getCreated_at(), 
			   this.getUpdated_at(), 
			   this.getContent(),
			   this.getStatus());
	}
	
	public static void Insert(int id, int userID, int postID, int level, int points, int reply_cmtID,
			int reply_userID, String created_at, String upStringd_at, String content, String status)
	{
		
		Document doc = new Document("id", id)
							.append("user_id", userID)
							.append("post_id", postID)
							.append("level", level)
							.append("points", points)
							.append("reply_cmtID", reply_cmtID)
							.append("reply_userID", reply_userID)
							.append("created_at", created_at)
							.append("updated_at", upStringd_at)
							.append("content", content)
							.append("status", status);
		Model.Insert(doc, CMT);
	}
	
	public static Comment Doc2Cmt(Document doc)
	{
		if (doc == null)
			return null;
		return new Comment(
				doc.getInteger("id"), 
				doc.getInteger("user_id"), 
				doc.getInteger("post_id"), 
				doc.getInteger("level"), 
				doc.getInteger("points"), 
				doc.getInteger("reply_cmtID"), 
				doc.getInteger("reply_userID"), 
				doc.getString("created_at"), 
				doc.getString("updated_at"), 
				doc.getString("content"), 
				doc.getString("status"));
	}
	
	public static Comment GetComment(int cmt_id)
	{
		Document doc = CMT.find(Filters.eq("cmt_id", cmt_id)).first();
		if (doc == null)
			return null;
		
		return Doc2Cmt(doc);
	}
	
	public static void Vote(int id, int point)
	{
		CMT.findOneAndUpdate(Filters.eq("id", id), Updates.inc("points", point));
	}
}

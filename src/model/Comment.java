package model;

import java.util.Date;

public class Comment {

	private String id;
	private String user_id ;
	private int post_id ;
	private int level;
	private int points;
	private int commentable_id;
	private String in_reply_to_comment;
	private String in_reply_to_user;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	private String contents;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public int getPost_id() {
		return post_id;
	}


	public void setPost_id(int post_id) {
		this.post_id = post_id;
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


	public int getCommentable_id() {
		return commentable_id;
	}


	public void setCommentable_id(int commentable_id) {
		this.commentable_id = commentable_id;
	}


	public String getIn_reply_to_comment() {
		return in_reply_to_comment;
	}


	public void setIn_reply_to_comment(String in_reply_to_comment) {
		this.in_reply_to_comment = in_reply_to_comment;
	}


	public String getIn_reply_to_user() {
		return in_reply_to_user;
	}


	public void setIn_reply_to_user(String in_reply_to_user) {
		this.in_reply_to_user = in_reply_to_user;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public Date getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}


	public Date getDeleted_at() {
		return deleted_at;
	}


	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public Comment(String id, String user_id, int post_id, int level, int points, int commentable_id, String in_reply_to_comment,
			String in_reply_to_user, Date created_at, Date updated_at, Date deleted_at, String contents_short) {
		super();
		this.post_id = post_id;
		this.id = id;
		this.user_id = user_id;
		this.level = level;
		this.points = points;
		this.commentable_id = commentable_id;
		this.in_reply_to_comment = in_reply_to_comment;
		this.in_reply_to_user = in_reply_to_user;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.contents = contents_short;
	}


	public Comment()
	{
		
	}
	
	
}


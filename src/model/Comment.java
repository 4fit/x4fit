package model;

public class Comment {
	private int post_id;
	private int cmt_id;
	private int reply_cmt_id;
	private int level;
	private int points;
	private String content;
	private String created_date;
	private String updated_date;
	private User user;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}
	public int getReply_cmt_id() {
		return reply_cmt_id;
	}
	public void setReply_cmt_id(int reply_cmt_id) {
		this.reply_cmt_id = reply_cmt_id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Comment()
	{
		
	}
	
	public Comment(int post_id, int cmt_id, int reply_cmt_id, int level, int points,
			String content, String created_date, String updated_date, User user)
	{
		this.post_id = post_id;
		this.cmt_id = cmt_id;
		this.reply_cmt_id = reply_cmt_id;
		this.level = level;
		this.points = points;
		this.content = content;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.user = user;
	}
}

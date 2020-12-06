package model;

import model.DB_conn;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class User extends DB_conn
{
	
	private String username;
	private String password;
	private String email;
	private int id;
	private String name;
	private int following_count;
	private int follower_count;	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFollowing_count() {
		return following_count;
	}
	public void setFollowing_count(int following_count) {
		this.following_count = following_count;
	}
	public int getFollower_count() {
		return follower_count;
	}
	public void setFollower_count(int follower_count) {
		this.follower_count = follower_count;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User()
	{
		this.username= " ";
		this.password= " ";
		this.email= " ";
	}
	
	public User(String username, String pass, String email )
	{
		this.username= username;
		this.password= pass;
		this.email= email;
		this.id=0;
		this.follower_count=0;
		this.following_count=0;
		this.name="avvsfd";
	
	}
	//TODO
	public Document getUserInfo(String user_id)
	{
		MongoCollection<Document> collection = database.getCollection("USER");
		return collection.find(Filters.eq("id", user_id)).first();
	}
	
	
}
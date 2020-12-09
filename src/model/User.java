package model;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import dao.DAO;

public class User
{	
	private int userId;
	private String username;
	private String name;
	private String password;
	private String email;
	private String avata;
	private int posts_count;
	private int following_count;
	private int follower_count;	
	private int clips_count;
	
	public User(int userId, String username, 
			String name, String pass, String email, 
			String avata, int posts_count, int following_count, int follower_count, int clips_count) {
		this.userId = userId;
		this.username= username;
		this.name = name;
		this.password= pass;
		this.email= email;
		this.avata = avata;
		this.posts_count = posts_count;
		this.following_count= following_count;
		this.follower_count = follower_count;
		this.clips_count= clips_count;
	}
	
	public User(String username, String pass, String email ) {
		
		this.username= username;
		this.password= pass;
		this.email= email;
		this.setClips_count(0);
		this.setFollower_count(0);
		this.setFollowing_count(0);
		this.setPostsCount(0);
		this.setName("");
		this.setAvata("");	
		this.userId=(int) DAO.getLastestID("USER")+1;
		
	
	}
	
	public User()
	{
		
	}
	
	public User (String username, String pass)
	{
		this.username= username;
		this.password= pass;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getAvata() {
		return this.avata;
	}
	
	public void setAvata(String newAvata) {
		this.avata = newAvata;
	}
	
	public int getPostsCount() {
		return this.posts_count;
	}
	
	public void setPostsCount(int posts_count) {
		this.posts_count = posts_count;
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
	/*
<<<<<<< HEAD
=======
	
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
		this.id= DB_conn.getLastestID("USER");
		this.follower_count=0;
		this.following_count=0;
		this.name=" ";
	}
	public User(String username, String pass,String email,String name, int follower,int following)
	{
		this.username= username;
		this.password= pass;
		this.email= email;
		this.id= DB_conn.getLastestID("USER");
		this.follower_count=follower;
		this.following_count=following;
		this.name=name;
	
	}
	
	public User(String username, String pass, String email )
	{
		this.username= username;
		this.password= pass;
		this.email= email;
		this.id= DB_conn.getLastestID("USER");
		this.follower_count=0;
		this.following_count=0;
		this.name="Hoàng";
	
	}*/
	//TODO

	public int getClips_count() {
		return clips_count;
	}

	public void setClips_count(int clips_count) {
		this.clips_count = clips_count;
	}

}

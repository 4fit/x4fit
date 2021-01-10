package model;

import java.util.ArrayList;
import java.util.List;

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
	private ArrayList<Integer> follower  ; // Tạo mảng follower
	private ArrayList<Integer> following; // Tạo mảng following
	private ArrayList<Integer> clips; // Tạo mảng clips id bài post
	
	
	public ArrayList<Integer> getClips() {
		return clips;
	}

	public void setClips(ArrayList<Integer> clips) {
		this.clips = clips;
	}

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
		ArrayList<Integer> follow  = new ArrayList<Integer>(); // set số lượng follow
		this.setFollower(follow);
		this.setFollowing(follow);
		this.setClips(follow);
		//System.out.print("Da toi luc tao nhan viên");
		
		
		this.userId=(int) DAO.getLastestID("USER")+1;
		
	
	}
	
public User(String name, String username, String pass, String email ) {
		
		this.name = name;
		this.username= username;
		this.password= pass;
		this.email= email;
		this.setClips_count(0);
		this.setFollower_count(0);
		this.setFollowing_count(0);
		this.setPostsCount(0);
		this.setAvata("");
		ArrayList<Integer> follow  = new ArrayList<Integer>(); // set số lượng follow
		this.setFollower(follow);
		this.setFollowing(follow);
		this.setClips(follow);
		//System.out.print("Da toi luc tao nhan viên");
		
		
		this.userId=(int) DAO.getLastestID("User")+1;
		
	
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
	
	public ArrayList<Integer> getFollower() {
		return follower;
	}

	public void setFollower(ArrayList<Integer> follower) {
		this.follower = follower;
	}

	public ArrayList<Integer> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<Integer>following) {
		this.following = following;
	}

	public int getClips_count() {
		return clips_count;
	}

	public void setClips_count(int clips_count) {
		this.clips_count = clips_count;
	}
	
	
	public void setID(int id) {
		this.userId = id;
	}
	
	
	public User(Document userDoc)
	{
		System.out.print(userDoc);
		this.setID(userDoc.getInteger("id"));
		this.setName(userDoc.getString("name"));
		this.setUsername(userDoc.getString("username"));
		this.setPassword(userDoc.getString("password"));
		this.setFollower_count(userDoc.getInteger("follower_count"));
		this.setFollowing_count(userDoc.getInteger("following_count"));
		this.setFollower((ArrayList<Integer>)userDoc.get("follower"));
		this.setClips((ArrayList<Integer>)userDoc.get("clips"));
		this.setFollowing((ArrayList<Integer>)userDoc.get("following"));
		this.setPostsCount(userDoc.getInteger("posts_count"));
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

	

}

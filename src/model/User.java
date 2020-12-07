package model;

public class User
{	
	private int userId;
	private String username;
	private String name;
	private String password;
	private String email;
	private String avata;
	private int posts_count;
	
	public User(int userId, String username, 
			String name, String pass, String email, 
			String avata, int posts_count) {
		this.userId = userId;
		this.username= username;
		this.name = name;
		this.password= pass;
		this.email= email;
		this.avata = avata;
		this.posts_count = posts_count;
	}
	
	public User(String username, String pass, String email ) {
		this.username= username;
		this.password= pass;
		this.email= email;
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
}

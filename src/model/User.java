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
	}
	//TODO
	public Document getUserInfo(String user_id)
	{
		MongoCollection<Document> collection = database.getCollection("USER");
		return collection.find(Filters.eq("id", user_id)).first();
	}
}

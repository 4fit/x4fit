package model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import x4fit.Utilities;

public class Account extends Model {

	private String username;
	private String password;
	private String email;
	private String user_type;
	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Account() {

	}

	public Account(String username, String password, String email, String user_type) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setUser_type(user_type);
		this.setUserID(getLastestID("USER") + 1);
	}

	public Account(String username, String password, String email) {
		this.setUsername(username);
		this.setPassword(password);
		this.setUser_type("USER");
		this.setUserID(getLastestID("USER") + 1);
	}
	
	public Account(int userID, String password, String user_type, String email)
	{
		this.setUserID(userID);
		this.setUser_type(user_type);
		this.setPassword(password);
		this.setEmail(email);
	}
	
	public static Account Doc2Account(Document doc)
	{
		return new Account(doc.getInteger("userID"),
						   doc.getString("password"),
						   doc.getString("user_type"),
						   doc.getString("email"));
	}
	
	public static Account GetAccountByUserID(int userID)
	{
		Document doc = ACCOUNT.find(Filters.eq("userID", userID)).first();
		if (doc == null)
			return null;
		return Doc2Account(doc);
	}
}

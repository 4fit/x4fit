package model;

import java.security.NoSuchAlgorithmException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import dao.DAO;
import x4fit.Utilities;


public class Account extends DAO{
	
	private String sUsername;
	private String sPassword;
	private String sEmail;
	
	public Account()
	{
		
	}
	
	public Account(String username, String password) throws NoSuchAlgorithmException
	{
		this.sUsername = username;
		//this.sPassword = x4fit.Utilities.sha1(password);
		this.sPassword = password;
	}
	
	public Account(String username, String password, String email)throws NoSuchAlgorithmException
	{
		this.sUsername = username;
		this.sPassword = password;
		this.sEmail = email;
	}
	
	public String getUsername(){
		return this.sUsername;
	}
	
	public String getPassword() {
		return this.sPassword;
	}
	
	public void setUsername(String username)
	{
		this.sUsername = username;
	}
	
	public void setPassword(String password)
	{
		this.sPassword = password;
	}

	public String getEmail()
	{
		return this.sEmail;
	}
	
	public void setEmail(String email)
	{
		this.sEmail = email;
	}
	
	
	
}

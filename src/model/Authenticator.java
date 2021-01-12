package model;

import org.bson.Document;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Authenticator extends Model{
	private int id;
	private String selector;
	private String validator;
	private int userID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSelector() {
		return selector;
	}
	public void setSelector(String selector) {
		this.selector = selector;
	}
	public String getValidator() {
		return validator;
	}
	public void setValidator(String validator) {
		this.validator = validator;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public Authenticator(int userID, String selector, String validator)
	{
		this.setId(getLastestID(AUTHENTICATION));
		this.setUserID(userID);
		this.setSelector(selector);
		this.setValidator(validator);
	}
	
	public static void Update(int userID, String selector, String validator)
	{
		AUTHENTICATION.updateOne(Filters.eq("user_id", userID), 
				Updates.combine(Updates.set("selector", selector),
								Updates.set("validator", validator)));
	}
	
	public void Insert() 
	{
		Document doc = new Document("id", this.getId())
				.append("selector", this.getSelector())
				.append("validator", this.getValidator())
				.append("user_id", this.getUserID());
		Model.Insert(doc, AUTHENTICATION);
	}
}

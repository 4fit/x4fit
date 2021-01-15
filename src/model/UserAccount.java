package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class UserAccount extends Model {
	protected int userID;
	protected String username;
	protected String email;
	protected String user_type;
	protected String fullname;
	protected String avatar;
	protected String url;
	protected String status;
	
	public int getUserID() {
		return userID;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getUser_type() {
		return user_type;
	}
	public String getFullname() {
		return fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	public String getUrl() {
		return url;
	}
	public String getStatus() {
		return status;
	}
	
	public UserAccount(int userID, String username, String email, String user_type, String fullname,
			String avatar, String url, String status) {
		super();
		this.userID = userID;
		this.username = username;
		this.email = email;
		this.user_type = user_type;
		this.fullname = fullname;
		this.avatar = avatar;
		this.url = url;
		this.status = status;
	}
	
	public static List<UserAccount> getAllUserInfo() {
		List<User> allUserList = User.getAllUsers();
		ArrayList<UserAccount> data = new ArrayList<UserAccount>();
		for (int i = 0; i < allUserList.size(); i++) {
			User user = allUserList.get(i);
			Account account = Account.GetAccountByUserID(user.getUserID());
			UserAccount userAccount = new UserAccount(user.getUserID(), account.getUsername(), 
					account.getEmail(), account.getUser_type(), user.getFullname(), 
					user.getAvatar(), user.getUrl(), user.getStatus());
			data.add(userAccount);
		}
		return data;
	}
}

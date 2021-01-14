package model;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
	
	private int userID;
	private String fullname;
	private String avatar;
	private String url;
	private List<Integer> follower;
	private List<Integer> following;
	private List<Integer> clips;
	private String status;
	private String username;
	private String password;
	private String email;
	private String user_type;
	
	public int getUserID() {
		return userID;
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
	
	public List<Integer> getFollower() {
		return follower;
	}
	
	public List<Integer> getFollowing() {
		return following;
	}
	
	public List<Integer> getClips() {
		return clips;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUser_type() {
		return user_type;
	}
	
	public UserAccount(int userID, String fullname, String avatar, String url, List<Integer> follower,
			List<Integer> following, List<Integer> clips, String status, String username, String password, String email,
			String user_type) {
		super();
		this.userID = userID;
		this.fullname = fullname;
		this.avatar = avatar;
		this.url = url;
		this.follower = follower;
		this.following = following;
		this.clips = clips;
		this.status = status;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_type = user_type;
	}

	public static List<UserAccount> getAllUserInfo() {
		ArrayList<UserAccount> data = new ArrayList<UserAccount>();
		List<User> allUsersList = User.getAllUsers();
		for (int i = 0; i < allUsersList.size(); i++) {
			User user = allUsersList.get(i);
			Account account = Account.GetAccountByUserID(user.getUserID());
			UserAccount userInfo = new UserAccount(account.getUserID(), user.getFullname(), 
					user.getAvatar(), user.getUrl(), user.getFollower(), user.getFollowing(), 
					user.getClips(), user.getStatus(), account.getUsername(), 
					account.getPassword(), account.getEmail(), account.getUser_type());
			data.add(userInfo);
		}
		return data;
	}
}

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;

public final class Report extends Model {
	
	private ObjectId id;
	private String time;
	private String description;
	private int userID;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public Report() {}
	
	public Report(ObjectId id, String time, String description, int userID) {
		super();
		this.id = id;
		this.time = time;
		this.description = description;
		this.userID = userID;
	}
	
	public static List<Report> getAllReports() {
		FindIterable<Report> cursor = REPORT.find();
		Iterator<Report> it = cursor.iterator();
		ArrayList<Report> listReports = new ArrayList<Report>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				listReports.add(it.next());
			}
		}
		return listReports;
	}
}

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class Report extends Model {
	
	private int id;
	private String time;
	private String description;
	private int userID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	
	public Report(int id, String time, String description, int userID) {
		super();
		this.id = id;
		this.time = time;
		this.description = description;
		this.userID = userID;
	}

	public static Report Doc2Report(Document doc)
	{
		if (doc == null)
			return null;
		return new Report(
				doc.getInteger("id"), 
				doc.getString("time"), 
				doc.getString("description"),
				doc.getInteger("user_id"));
	}
	
	public static List<Report> getAllReports() {
		FindIterable<Document> cursor = REPORT.find();
		Iterator<Document> it = cursor.iterator();
		ArrayList<Report> listReports = new ArrayList<Report>();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Document doc = it.next();
				Report report = Report.Doc2Report(doc);
				listReports.add(report);
			}
		}
		return listReports;
	}
}

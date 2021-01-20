package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;

import x4fit.Utilities;

public final class Report extends Model {
	
	private ObjectId id;
	private ObjectId obj_id;
	private String type;
	private String time;
	private String description;
	private ObjectId account_id;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public ObjectId getObj_id() {
		return obj_id;
	}
	public void setObj_id(ObjectId obj_id) {
		this.obj_id = obj_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public ObjectId getAccount_id() {
		return account_id;
	}
	public void setAccount_id(ObjectId account_id) {
		this.account_id = account_id;
	}
	public Report() {}
	
	public Report(ObjectId obj_id, String type, String description, ObjectId account_id) {
		this.id = new ObjectId();
		this.obj_id = obj_id;
		this.type = type;
		this.time = Utilities.GetCurrentDateTime();
		this.description = description;
		this.account_id = account_id;
	}
	
	@BsonIgnore
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
	
	public void Insert()
	{
		REPORT.insertOne(this);
		
	}
}

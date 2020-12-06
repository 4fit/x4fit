package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import controller.comment;

public class DB_Comment extends DB_conn{
	
	public void insertCommentByIdUserAndIdPost( Comment cmt)
	{
		Document doc = new Document()
		.append("id", new ObjectId())
		.append("user_id", cmt.getUser_id())
		.append("post_id", cmt.getPost_id())
		.append("created_at", cmt.getCreated_at())
		.append("contents", cmt.getContents());
		//mongoClient.setWriteConcern(WriteConcern.SAFE);
		Insert(doc, "COMMENT");
	}
	 
	public boolean isHaveCommentPostByIdUser(int post_id, String user_id)
	{
		MongoCollection<Document> collection = database.getCollection("COMMENT");
		//BasicDBObject andQuery = new Bis
		return false;
	}
	
	public List<Comment> getCommentByIdPost(int post_id)
	{
		List<Comment> listCmt = new ArrayList<Comment>();
		MongoCollection<Document> collection = database.getCollection("COMMENT");
		FindIterable<Document> cursor = collection.find(Filters.eq("post_id", post_id));
		Iterator<Document> list = cursor.iterator();
		while(list.hasNext())
		{
			
			listCmt.add(getCommentByDocUsingCmtDoc(list.next()));
		}
		return listCmt;
		
	}
	
	public Comment getCommentByDocUsingCmtDoc(Document cmtDoc)
	{
		DB_User db = new DB_User();			
		Document userDoc  = db.getUserInfo(cmtDoc.getString("user_id"));
		System.out.print(userDoc);
		Comment cmt = new Comment(cmtDoc, userDoc);
		//Comment cmt = new Comment();
		//cmt.setName_user(userDoc.getString("username"));
		return cmt;
	}
}

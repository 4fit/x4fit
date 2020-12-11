package dao;

import model.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class CommentDetailPostDAO extends DAO {

	public static MongoCollection<Document> CMT = db.getCollection("COMMENT");
	
	public static int getCmtID()
	{
		return DAO.getLastestID(CMT) + 1;
	}
	
	public void insertCommentByIdUserAndIdPost( CommentDetailPost cmt)
	{
		Document doc = new Document()
		.append("_id", new ObjectId())
		.append("id", getCmtID())
		.append("user_id", cmt.getUser_id())
		.append("post_id", cmt.getPost_id())
		.append("created_at", cmt.getCreated_at())
		.append("contents", cmt.getContents());
		//mongoClient.setWriteConcern(WriteConcern.SAFE);
		Insert(doc, "COMMENT");
	}
	 
	public boolean isHaveCommentPostByIdUser(int post_id, String user_id)
	{
		MongoCollection<Document> collection = DAO.db.getCollection("COMMENT");
		//BasicDBObject andQuery = new Bis
		return false;
	}
	
	public List<CommentDetailPost> getCommentByIdPost(int post_id)
	{
		List<CommentDetailPost> listCmt = new ArrayList<CommentDetailPost>();
		MongoCollection<Document> collection = DAO.db.getCollection("COMMENT");
		FindIterable<Document> cursor = collection.find(Filters.eq("post_id", post_id));
		Iterator<Document> list = cursor.iterator();
		while(list.hasNext())
		{
			
			listCmt.add(getCommentByDocUsingCmtDoc(list.next()));
		}
		return listCmt;
		
	}
	
	public CommentDetailPost getCommentByDocUsingCmtDoc(Document cmtDoc)
	{
		UserDAO db = new UserDAO();
		
		Document userDoc ;
		try
		 {
			userDoc  = db.getUserInfo(cmtDoc.getInteger("user_id"));
		 }
		catch(Exception e)
		{
			userDoc  = db.getUserInfo(Integer.parseInt(cmtDoc.getString("user_id")));
		}
		 
		CommentDetailPost cmt = new CommentDetailPost(cmtDoc, userDoc);
		//Comment cmt = new Comment();
		//cmt.setName_user(userDoc.getString("username"));
		return cmt;
	}
}

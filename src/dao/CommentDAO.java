package dao;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import dao.DAO;
import model.Comment;
import model.User;

public class CommentDAO extends DAO {
	
	public static MongoCollection<Document> CMT = db.getCollection("COMMENT");
	
	public static int getCmtID()
	{
		return DAO.getLastestID("COMMENT") + 1;
	}
	
	public static void Insert_Cmt(Comment cmt)
	{
		Insert_Cmt(cmt.getPost_id(), cmt.getCmt_id(), cmt.getReply_cmt_id(), cmt.getLevel(), 
				cmt.getPoints(), cmt.getContent(), cmt.getCreated_date(), cmt.getUpdated_date(), cmt.getUser());
	}
	
	public static void Insert_Cmt(int post_id, int cmt_id, int reply_cmt_id, int level, int points,
			String content, String created_date, String updated_date, User user)
	{
		Document doc = new Document("post_id", post_id)
							.append("cmt_id", cmt_id)
							.append("reply_cmt_id", reply_cmt_id)
							.append("level", level)
							.append("points", points)
							.append("content", content)
							.append("created_date", created_date)
							.append("updated_date", updated_date)
							.append("user", user);
		DAO.Insert(doc, CMT);
	}
	
	public static Comment Doc2Cmt(Document doc)
	{
		return new Comment(doc.getInteger("post_id"),
							doc.getInteger("cmt_id"),
							doc.getInteger("reply_cmt_id"),
							doc.getInteger("level"),
							doc.getInteger("points"),
							doc.getString("content"),
							doc.getString("created_date"),
							doc.getString("updated_date"),
							(User)doc.get("user"));
	}
	
	public static Comment GetComment(int cmt_id)
	{
		Document doc = CMT.find(Filters.eq("cmt_id", cmt_id)).first();
		if (doc == null)
			return new Comment();
		
		Comment cmt = new Comment();
		try
		{
			cmt = Doc2Cmt(doc);
		}
		catch (Exception e) {
		
		}
		return cmt;
	}
}
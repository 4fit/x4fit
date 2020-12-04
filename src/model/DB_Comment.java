package model;

import org.bson.Document;
import org.bson.types.ObjectId;

import controller.comment;

public class DB_Comment extends DB_conn{
	
	public void insertCommentByIdUserAndIdPost( Comment cmt)
	{
		Document doc = new Document();
		doc.append("_id", new ObjectId());
		doc.append("user_id", cmt.getUser_id());
		doc.append("post_id", cmt.getPost_id());
		doc.append("created_at", cmt.getCreated_at());
		doc.append("contents", cmt.getContents());
		Insert(doc, "COMMENT");
	}
}

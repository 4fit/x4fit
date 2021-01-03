package controller;

import org.bson.Document;
import org.bson.conversions.Bson;

import model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/detail")
public class detailController extends HttpServlet {
	
	public static User user = new User();
	public static Post dbDetail = new Post();
	public static int idPostMain;
	
	private static final long serialVersionUID = 1L;
       
    public detailController() {
        super();
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	
    	response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
//		String pUrl = (String) request.getParameter("p");
//		HttpSession session = request.getSession();
//		Post postMain = PostDAO.GetPost(pUrl); 
		String username_author = "";
		String nameAuthor = "";
		String tilte = "";
		String contentMain = "Bài viết không tồn tại !";
		int clips_count = 0;
		int view = 0;
		int countComment = 0;
		
		HttpSession session = request.getSession();
		
		Post p = new Post();
		if(request.getParameter("test")!= null)
			idPostMain = Integer.parseInt(request.getParameter("test")); // Nhận ID bài postController từ trang home
		if(session.getAttribute("idPostMain") != null)
			idPostMain = (int)(session.getAttribute("idPostMain"));
		
	
    	Document post = detailController.dbDetail.getPostByIdPost(idPostMain);
    	if(post != null)
    	{
    		
	    	Document author = (Document)post.get("user");
	       	username_author = author.getString("username");
	       	nameAuthor = author.getString("name");
	       	
	       	p = detailController.dbDetail.Doc2Post(post);
	       	tilte = p.getTitle();
	       	view = p.getViews_count();
	       	clips_count = p.getClips_count();
	       	contentMain = p.getContent();
	       	countComment = detailController.dbDetail.countComment(idPostMain);
	       	
	       	// POST của user về bài viết đó
	       	List<Post> listPost = detailController.dbDetail.getPostOfUser(p.getID());
	    	
	    	//List commentController của bài viết đó
	    	List<Comment> listCmt = getListComment(idPostMain);
	    	Collections.reverse(listCmt); // Đảo ngược list commentController
	    	session.setAttribute("listCmt", listCmt);
	    	session.setAttribute("listPost", listPost);
       	
    	}
    	
    	if (username_author == null || username_author == "")
    		username_author = " UsernameAuthor";
    	
    	if (nameAuthor == null || nameAuthor == "")
    		nameAuthor = "Name Author";
    	
    	if(tilte == null || tilte == "")
    		tilte = "Title postController";
    	
    	session.setAttribute("username_author", username_author);
    	session.setAttribute("content", contentMain);
    	session.setAttribute("name_author", nameAuthor);
    	session.setAttribute("title_post",tilte );
    	session.setAttribute("view_post", view);
    	session.setAttribute("Clip_post_count", clips_count);
    	session.setAttribute("countComment", countComment);
    	session.setAttribute("idPostMain", idPostMain);
    	
    	if(request.getParameter("userCurrentAction")!= null)
    	{
    		int userIdCurrent = (int)(session.getAttribute("userIdCurrent"));
    		if(request.getParameter("userCurrentAction").equals("follow"))
	    	{
	    		
	    		detailController.user.addFollowingForIdUser(p.getUser_id(),userIdCurrent);
	    		RequestDispatcher  dispatcher = request.getRequestDispatcher("/detailController/detailController.jsp");	       
		   	   	dispatcher.forward(request, response);
	    	}
    	
	    	else if(request.getParameter("userCurrentAction").equals("add_clips")){
	    		
	    		updateClipsCount(userIdCurrent, p.getID());
	    	}
    		
	    	else if(request.getParameter("userCurrentAction").equals("add_downvote")){
	    		updateVote("downvote", userIdCurrent , p.getID());
	    	}
    		
	    	else if(request.getParameter("userCurrentAction").equals("add_upvote")){
	    		updateVote("upvote", userIdCurrent , p.getID());
	    	}
    	}
	    else
	    {

	    	RequestDispatcher  dispatcher = request.getRequestDispatcher("/detailController/detailController.jsp");	       
	   	   	dispatcher.forward(request, response);
	    	
	    }
    	   

	}
    
    public void updateVote(String nameField, int user_id, int post_id)
    {	
    	detailController.dbDetail.updateItem(nameField, user_id, post_id); // update lại số user đã gim bài viết   	
    }

    public void updateClipsCount(int user_id, int post_id)
    {
    	
    	detailController.dbDetail.updateItem("clips", user_id, post_id); // update lại số user đã gim bài viết 	
    	detailController.user.updateClipsItem(user_id, post_id); // update clips id của bài postController cho user hiện tại
    	
    }
    
    public List<Comment> getListComment(int post_id)
    {
    	Comment cmt = new Comment();
    	return cmt.getAllCommentByPostID(post_id);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

}

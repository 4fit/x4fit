package controller;

import org.bson.Document;
import org.bson.conversions.Bson;

import model.*;
import dao.*;
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
import javax.servlet.http.HttpSessionContext;

/**
 * Servlet implementation class detailPost
 */
@WebServlet("/detailPost")
public class detailPost extends HttpServlet {
	
	public static UserDAO dbUser = new UserDAO();
	public static DetailPostDAO dbDetail = new DetailPostDAO();
	public static int idPostMain;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailPost() {
        super();
        // TODO Auto-generated constructor stub
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
			idPostMain = Integer.parseInt(request.getParameter("test")); // Nhận ID bài post từ trang home
		if(session.getAttribute("idPostMain") != null)
			idPostMain = (int)(session.getAttribute("idPostMain"));
		
	
    	Document post = detailPost.dbDetail.getPostByIdPost(idPostMain);
    	if(post != null)
    	{
    		
	    	Document author = (Document)post.get("user");
	       	username_author = author.getString("username");
	       	nameAuthor = author.getString("name");
	       	
	       	p = detailPost.dbDetail.ConverseToPost(post);
	       	tilte = p.getTitle();
	       	view = p.getViews_count();
	       	clips_count = p.getClips_count();
	       	contentMain = p.getContent();
	       	countComment = detailPost.dbDetail.countComment(idPostMain);
	       	
	       	// POST của user về bài viết đó
	       	List<Post> listPost = detailPost.dbDetail.getPostOfUser(p.getID());
	    	
	    	//List comment của bài viết đó
	    	List<CommentDetailPost> listCmt = getListComment(idPostMain);
	    	Collections.reverse(listCmt); // Đảo ngược list comment
	    	session.setAttribute("listCmt", listCmt);
	    	session.setAttribute("listPost", listPost);
       	
    	}
    	
    	if (username_author == null || username_author == "")
    		username_author = " UsernameAuthor";
    	
    	if (nameAuthor == null || nameAuthor == "")
    		nameAuthor = "Name Author";
    	
    	if(tilte == null || tilte == "")
    		tilte = "Title post";
    	
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
	    		
	    		detailPost.dbUser.addFollowingForIdUser(p.getUser_id(),userIdCurrent);
	    		RequestDispatcher  dispatcher = request.getRequestDispatcher("/detailPost/detailPost.jsp");	       
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

	    	RequestDispatcher  dispatcher = request.getRequestDispatcher("/detailPost/detailPost.jsp");	       
	   	   	dispatcher.forward(request, response);
	    	
	    }
    	   

	}
    
    public void updateVote(String nameField, int user_id, int post_id)
    {	
    	detailPost.dbDetail.updateItem(nameField, user_id, post_id); // update lại số user đã gim bài viết   	
    }

    public void updateClipsCount(int user_id, int post_id)
    {
    	
    	detailPost.dbDetail.updateItem("clips", user_id, post_id); // update lại số user đã gim bài viết 
    	
    	detailPost.dbUser.updateClipsItem(user_id, post_id); // update clips id của bài post cho user hiện tại
    	
    }
    
    
    
    
    public List<CommentDetailPost> getListComment(int post_id)
    {
    	CommentDetailPostDAO db = new CommentDetailPostDAO();
    	List<CommentDetailPost> listCmt = new ArrayList<CommentDetailPost>();
    	listCmt = db.getCommentByIdPost(post_id);
    	return listCmt;
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

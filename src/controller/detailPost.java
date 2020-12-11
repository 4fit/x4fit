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
//		
//		HttpSession session = request.getSession();
//		Post postMain = (Post)session.getAttribute("post_main");
//		int post_id_main = postMain.p_id;
//		int clips_count_main = postMain.p_clips_count;
//		int user_id = 0;
		
//		if(request.getParameter("active").equals("add_clips")){
//			//updateClipsCount(user_id, post_id_main, clips_count_main);
//		
//		}
//		else
//		
//		{
			System.out.print("daden");
			Post p = new Post();
			int idIndext = Integer.parseInt(request.getParameter("test"));
			
	    	Document post = detailPost.dbDetail.getPostByIdPost(idIndext);
	    	p = detailPost.dbDetail.ConverseToPost(post);
	    	System.out.print(post);
	    	User user = new User();
	    	String tilte = p.getTitle();
	    	int view = p.getViews_count();
	    	int clips_count = p.getClips_count();
	    	String nameAuthor = "";/* user.getUserInfo((String) post.get("user_id")).get("name").toString();*/
	    	
	    	if (nameAuthor == null || nameAuthor == "")
	    		nameAuthor = "Name Author";
	    	
	    	if(tilte == null || tilte == "")
	    		tilte = "Title post";
	    	request.setAttribute("content", p.getContent());
	    	request.setAttribute("name_author", nameAuthor);
	    	request.setAttribute("title_post",tilte );
	    	request.setAttribute("view_post", view);
	    	request.setAttribute("Clip_post_count", clips_count);
	    	//request.setAttribute("post", p);
	    	
	    	List<Post> listPost = new ArrayList<Post>();
	    	listPost.add(p);
	    	listPost.add(p);
	    	
	    	List<CommentDetailPost> listCmt = getListComment(1);
	    	Collections.reverse(listCmt); // Đảo ngược list comment
	    	request.setAttribute("listCmt", listCmt);
	    	request.setAttribute("listPost", listPost);
	    	System.out.print("Hello");
	    	  RequestDispatcher  dispatcher = request.getRequestDispatcher("/detailPost/detailPost.jsp");	       
	   	   dispatcher.forward(request, response);
		}
   // }
    
    public void updateClipsCount(int user_id, int post_id, int clips_count)
    {
    	
    	detailPost.dbDetail.updateClipsCountOfPost(post_id, clips_count + 1);
    	detailPost.dbUser.updateClipsItem(user_id, post_id);
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
		doGet(request, response);
	}

}

package controller;

import java.util.Date;

import model.*;
import dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class commentDetailPost
 */
@WebServlet("/commentDetailPost")
public class commentDetailPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentDetailPost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
    	int post_id =  (int)session.getAttribute("idPostMain");
    	int user_id = 1;
    	  // Biến tạm của bài post
    	Date created_at =java.util.Calendar.getInstance().getTime();
    	String comment_contents = request.getParameter("comment_contents");
    	CommentDetailPost cmt = new CommentDetailPost();
    	cmt.setUser_id(user_id);
    	cmt.setCreated_at(created_at);
    	cmt.setPost_id(post_id);
    	cmt.setContents(comment_contents);
    	CommentDetailPostDAO dbCmt = new CommentDetailPostDAO();
    	dbCmt.insertCommentByIdUserAndIdPost(cmt);
    	String url = "detailPost/detailPost.jsp";
//    	 RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
//	       
// 		dispatcher.forward(request, response);
    	
//    	String url = "/detailPost";
//		response.sendRedirect(request.getContextPath() + url);
    	response.sendRedirect(url);
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

}

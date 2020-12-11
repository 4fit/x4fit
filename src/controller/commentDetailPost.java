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
    	int user_id = 1;
    	int post_id = 1;
    	Date created_at =java.util.Calendar.getInstance().getTime();
    	String comment_contents = request.getParameter("comment_contents");
    	CommentDetailPost cmt = new CommentDetailPost();
    	cmt.setUser_id(user_id);
    	cmt.setCreated_at(created_at);
    	cmt.setPost_id(post_id);
    	cmt.setContents(comment_contents);
    	CommentDetailPostDAO dbCmt = new CommentDetailPostDAO();
    	dbCmt.insertCommentByIdUserAndIdPost(cmt);
    	String url = "detailPost.jsp";
//    	 RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
//	       
// 		dispatcher.forward(request, response);
    	response.sendRedirect(url);
    	
    }

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

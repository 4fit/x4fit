
package controller;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comment;
import model.DB_Comment;

/**
 * Servlet implementation class comment
 */
@WebServlet("/comment")
public class comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment() {
        super();
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String user_id = "1";
    	int post_id = 1;
    	Date created_at =java.util.Calendar.getInstance().getTime();
    	String comment_contents = request.getParameter("comment_contents");
    	Comment cmt = new Comment();
    	cmt.setUser_id(user_id);
    	cmt.setCreated_at(created_at);
    	cmt.setPost_id(post_id);
    	cmt.setContents(comment_contents);
    	DB_Comment dbCmt = new DB_Comment();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		process(request, response);
	}

}

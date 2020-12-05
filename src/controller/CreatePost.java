
package controller;

import model.PostDAO;
import model.Post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePost() {
        super();
    }
    
    private void Create(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException 
    {
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//title
		String title = request.getParameter("title");
		//user_id
		String user_id = request.getParameter("user_id");
		//is_public
		boolean is_public = request.getParameter("is_public") != null;
		//tags
		String tags = request.getParameter("tags");
		//image
		String thumbnail_url = request.getParameter("thumbnail_url");
		//contents
		String content = request.getParameter("content");
		
		//Tạo đối tượng post
		Post post = new Post(title, user_id, content, is_public, thumbnail_url, tags);
		
		//p
		String p = post.getP();
		
		PostDAO.Insert_Post(post);
;		
		String url = "/post";
		response.sendRedirect(request.getContextPath() + url + "?p=" + p);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Create(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}

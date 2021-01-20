
package controller;

import model.Authentication;
import model.Model;
import model.Post;
import model.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;

@WebServlet("/create")
public class createController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public createController() {
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
		HttpSession session = request.getSession();
		ObjectId accout_id = User.GetAccountIdFromCookies(request.getCookies());
		//is_public
		boolean is_public = request.getParameter("is_public") != null;
		//category
		String category = request.getParameter("category");
		//image
		String thumbnail_url = request.getParameter("thumbnail_url");
		//contents
		String content = request.getParameter("content");
		
		//Tạo đối tượng postController
		Post post = new Post(title, accout_id, content, is_public, thumbnail_url, category);
		post.Insert();
		//p
		String p = post.getUrl();
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

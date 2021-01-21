
package controller;

import model.Category;
import model.Post;
import model.User;

import java.io.IOException;
import java.util.List;

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
		//account_id
		ObjectId accout_id = User.GetAccountIdFromCookies(request.getCookies());
		if (accout_id != null)
		{
			//title
			String title = request.getParameter("title");
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
			
			HttpSession session = request.getSession();
			session.setAttribute("is_create", false);
			//p
			String p = post.getUrl();
			String url = "/post";
			response.sendRedirect(request.getContextPath() + url + "?p=" + p);
		}
		else
		{
			String url = "/login";
			response.sendRedirect(request.getContextPath() + url);
		}
	}

	protected void Input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ObjectId accout_id = User.GetAccountIdFromCookies(request.getCookies());
		if (accout_id != null)
		{
			String url =  "/posts/create.jsp";
			List<Category> lstCategories = Category.GetAllCategories();
			request.setAttribute("lstCat", lstCategories);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else
		{
			String url = "/login";
			response.sendRedirect(request.getContextPath() + url);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		boolean is_create = request.getParameter("is_create")!=null;
		if (is_create)
		{
			System.out.println("create");
			Create(request, response);
		}
		else
		{
			System.out.println("input");
			Input(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}

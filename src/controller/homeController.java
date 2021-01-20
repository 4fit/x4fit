package controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;

import model.Post;
import model.User;

@WebServlet("/home")
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private ArrayList<Post> topPosts;
    
    public homeController() {
        super();
    }

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		topPosts = Post.GetLastestPost(20);
	
		Cookie[] cookies = request.getCookies();
		if (cookies!=null)
		{
			ObjectId userID = User.GetAccountIdFromCookies(cookies);
			if (userID != null)
			{
				User user = User.GetUserByUserID(userID);
				request.setAttribute("user", user);
				request.setAttribute("is_logged", true);
			}
			else
			{
				request.setAttribute("is_logged", false);
			}
		}
		else
		{
			request.setAttribute("is_logged", false);
		}
		ObjectId userID = User.GetAccountIdFromCookies(cookies);
		
		request.setAttribute("topPosts", topPosts);
		
		String url = "/index.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);     
    }
    
    public List<Post> getListPostForSearch(String textSearch)
    {
    	
    	List<Post> listPost = new ArrayList<Post>();

    	listPost = Post.SearchPost(textSearch);
    	return listPost;
    }

    
    public List<User> getListAuthorForSearch(String textSearch)
    {
    	
    	List<User> listUser = new ArrayList<User>();
    	listUser = Post.searchAuthor(textSearch);
    	return listUser;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

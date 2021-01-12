package controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Post;
import model.User;

@WebServlet(urlPatterns = {"/home", "/index"})
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private ArrayList<Post> topPosts;
    private ArrayList<User> lstAuthors;
    
    public homeController() {
        super();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    	topPosts = Post.GetLastestPost(20);
//    	lstAuthors = new ArrayList<User>();
//    	for (Post p : topPosts) {
//			User user = User.GetUserByUserID(p.getUser_id());
//			lstAuthors.add(user);
//		}
//    
//    	request.setAttribute("topPosts", topPosts);
//    	request.setAttribute("lstAuthors", lstAuthors);
//    	
//    	String url = "/index.jsp";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//    


    	if(request.getParameter("userCurrentAction").equals("search_home"))
    	{
		
    		String textSearch = request.getParameter("textSearch");
	    	if(textSearch != "")
	    	{
	    		
	    		request.setAttribute("listPost",getListPostForSearch(textSearch));
	    		request.setAttribute("listAuthor",getListAuthorForSearch(textSearch));
	    		RequestDispatcher dis = getServletContext().getRequestDispatcher("/detailPost/search.jsp");	       
	
	
	
	       	   	dis.forward(request, response);
	    	}
    	}
    	else
    		
    	{ 
        	topPosts = Post.GetLastestPost(20);
        	lstAuthors = new ArrayList<User>();
        	for (Post p : topPosts) {
    			User user = User.GetUserByUserID(p.getUser_id());
    			lstAuthors.add(user);
    		}
        
        	request.setAttribute("topPosts", topPosts);
        	request.setAttribute("lstAuthors", lstAuthors);
        	
        	String url = "/index.jsp";
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    		dispatcher.forward(request, response);
    	}
        
    }
    
    public List<Post> getListPostForSearch(String textSearch)
    {
    	
    	List<Post> listPost = new ArrayList<Post>();

    	listPost = Post.searchPost(textSearch);
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

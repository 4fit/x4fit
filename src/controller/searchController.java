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

import model.Post;
import model.User;

/**
 * Servlet implementation class searchController
 */
@WebServlet("/search")
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	if(request.getParameter("userCurrentAction")!= null)
    	{
    		if(request.getParameter("userCurrentAction").equals("search_home"))
        	{
        		String textSearch = request.getParameter("textSearch");
    	    	if(textSearch != "")
    	    	{
    	    		List<Post> listPost = getListPostForSearch( textSearch);
    	    		List<User> listAuthor = getListAuthorForSearch(textSearch);
    	    		
    	    		request.setAttribute("listPost",listPost);
    	    		request.setAttribute("listAuthor",listAuthor);
    	    		request.setAttribute("lenListpost",listPost.size());
    	    		request.setAttribute("lenListauthor",listAuthor.size());
    	    		request.setAttribute("textSearch",textSearch);
    	    	}
        	}
    	}

    	RequestDispatcher dis = getServletContext().getRequestDispatcher("/detailPost/search.jsp");	          
   	   	dis.forward(request, response);
    	
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
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

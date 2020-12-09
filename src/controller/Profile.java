package controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import dao.PostDAO;
import model.Post;
import model.User;

//@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PostDAO post = new PostDAO();
    public Profile() {
       
    }
    
    public void getListPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
    	//String url="/index.jsp";
    	HttpSession session = request.getSession();
    	User user=new User();
    	if(session.getAttribute("Page")=="login" && session.getAttribute("Verification")=="Yes")
    	{

        	user= (User) session.getAttribute("USER");
        	//System.out.print(user.getEmail()+ user.getId());
        	if(user!=null)
        	{
        		System.out.print("vÀO JAVA "+ user.getName()+ user.getUserId());
        		List<Post> posts=post.readAllPersonalPost(2);
        		System.out.print("size"+posts.size());
            	request.setAttribute("listpost", posts);
            	//url="/users/profile.jsp";
        	}  	
    	}
    	else
    	{
    		System.out.print( "ddasddads" +user.getName()+ user.getUserId());
    		//url= "/login/login.jsp";
    		
    	}
    	 //RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);	       
		// dispatcher.forward(request, response);
    	//MongoCollection<Document> collection= post.getPostbyIDuser(1);

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getListPost(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

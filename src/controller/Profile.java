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
	User usermodel= new User();
    public Profile() {
       
    }
    
    public void getListFollower(User user, HttpSession session, HttpServletRequest request)
    {
    	if(session.getAttribute("Page")=="login" && session.getAttribute("Verification")=="Yes")
    	{  		
        	if(user!=null)
        	{
        		
        		List<User> userfollower= user.getListFollower(user.getUserId());
            	request.setAttribute("FOLLOWER", userfollower);
        	}      
    	}
    }
    
    
    public void getListFollowing(User user, HttpSession session, HttpServletRequest request)
    {
    	if(session.getAttribute("Page")=="login" && session.getAttribute("Verification")=="Yes")
    	{  		
        	if(user!=null)
        	{
        		
        		List<User> userfollowing= user.getListFollowing(user.getUserId());
            	request.setAttribute("FOLLOWING", userfollowing);
        	}      
    	}
    }
    
    public void getListPost(User user, HttpSession session, HttpServletRequest request) throws ServletException, IOException
    {   	
    	
    	if(session.getAttribute("Page")=="login" && session.getAttribute("Verification")=="Yes")
    	{  		
        	if(user!=null)
        	{
        		List<Post> posts=post.readAllPersonalPost(user.getUserId());
            	request.setAttribute("listpost", posts);
        	}      
    	}
    	
      }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
    	System.out.print("vào profile");
    	usermodel= (User) session.getAttribute("USER");
		getListPost(usermodel,session,request);
		getListFollower(usermodel, session, request);
		getListFollowing(usermodel, session, request);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

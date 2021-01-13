package controller;

import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

import model.Account;
import model.Post;
import model.User;

@WebServlet("/profile")
public class profileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Post post= new Post();
	User user= new User();
	public User ValidateUser(HttpServletRequest request)
	{
		Cookie[]  cookies = request.getCookies();
		//if(cookies[0].getName()!="selector" && cookies[1].getName()!=" validator")
		{
			
			user=User.GetUserInfoFromCookies(cookies);
			System.out.print("vào cookie "+ cookies);
			if(user!= null)
			{
				request.setAttribute("usermain", user);
				return user;
			}
			return null;
		}
		//else return null;		
	
	}
	
	
	
	public void getListBookmark(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("clipspost", user.getBookmarkPost(user));
		
	}
	
	public void getFollowingUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("following", user.getFollowingUser(user));
		
		
	}	
	
	public void getFollowerUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("follower", user.getFollowerUser(user));
		
		
	}	
	
	public void getListPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
			// System.out.print(user.getEmail()+ user.getId());
		List<Post> posts = post.readAllPersonalPost(user.getUserID());
		request.setAttribute("listpost", posts);
	}
	
	@SuppressWarnings("static-access")
	public void updateProfile (HttpServletRequest request)
	{
		String fullname =request.getParameter("fullname").toString();
		String email = request.getParameter("email").toString();
		String username =request.getParameter("username").toString();
		String currentpassword = request.getParameter("currentpass").toString();
		String newpass = request.getParameter("newpass").toString();
		String oldpass= request.getParameter("oldpass".toString());
		String confirm = request.getParameter("confirmnewpass").toString();
		User currentuser= ValidateUser(request);
		boolean valid= true;
		boolean changeAccount= false;
		if(fullname.equals(""))
		{
			request.setAttribute("nameError", "You have to fill full name!");
			valid= false;
		}
		else
			request.setAttribute("nameError","");
		
		if(email.equals(""))
		{
			request.setAttribute("emailError", "You have to fill your email!");
			valid= false;
		}
		else
			request.setAttribute("emailError","");
		if(username.equals(""))
		{
			valid=false;
			request.setAttribute("usernameError","You have to fill username!");
		}
		else
		{
			User a= User.getUserByUsername(username);
			if(a!=null && a!=currentuser )
			{
				valid=false;
				request.setAttribute("usernameError","This username is exists!");

			}
			else
				request.setAttribute("usernameError","");
		}
		if(!(oldpass.equals("") && newpass.equals("") && confirm.equals("")))
		{
			if(oldpass.equals("")  )
			{
				changeAccount=false;
				request.setAttribute("oldpassError","You have to confirm your old password!");
			}
			else
				request.setAttribute("oldpassError","");
				if(confirm.equals(""))
				{
					changeAccount=false;
					request.setAttribute("confirmError", "Your have to fill confirm your new Password!");
				}
				else
					request.setAttribute("confirmError","");
			if(newpass.equals(""))
			{
				changeAccount=false;
				request.setAttribute("newpassError", "Your have to fill your new Password!");

			}
			else
				request.setAttribute("newpassError","");
				
			valid= false;
			
			if(!oldpass.equals("") && !newpass.equals("") && !confirm.equals(""))
			{
				if(!newpass.equals(confirm))
				{
					changeAccount=false;
					request.setAttribute("confirmError", "Your confirm Password is not correct!");
					valid=false;
				}
				
				if(checkPassword(oldpass, request)==false)
				{
					changeAccount=false;
					request.setAttribute("oldpassError", "Your old password is not correct!");
					valid=false;
				}
			
			}
		}
		else
		{
			changeAccount=false;
		}
	
		
		if(valid==true)
		{
			if(changeAccount==false)
			{
				user.updateInforUser(currentuser.getUserID(), fullname, email, username, "");
			}
			else
				user.updateInforUser(currentuser.getUserID(), fullname, email, username, newpass);
		}
			
	}
	 
	public boolean checkPassword(String pass,HttpServletRequest request)
	{
		User u =ValidateUser(request);
		return u.checkPassword(u, pass);
	}
	
	public void showProfile( HttpServletRequest request, User user)
	{
		Account a= Account.GetAccountByUserID(user.getUserID());
	   request.setAttribute("acc", a);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url= "/404.jsp";
		User usercurrent= ValidateUser(request);
		if(usercurrent!=null)
		{
			System.out.print("Hellooskfnksnf ");
			if(request.getParameter("action")=="edit")
				updateProfile(request);
			showProfile(request, usercurrent);
			getListPost(request, response);
			getListBookmark(request, response);
			//getFollowingUser(request, response);
			//getFollowerUser(request, response);
			
			url="/users/profile.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher (url);
			dispatcher.forward(request, response);
			//response.sendRedirect(request.getContextPath()+url);
			
		}
		else 
		{
			url="/login/login.jsp";
			response.sendRedirect(request.getContextPath()+url);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}

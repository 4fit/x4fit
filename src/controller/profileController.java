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

import model.Post;
import model.User;

@WebServlet("/profile")
public class profileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void GetUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		String ver = (String) session.getAttribute("Verification");
		if (userID >= 0) {
			response.sendRedirect("../login/signup.jsp");
		}
		else
		{
			String url = "/users/profile.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}	
	}

	public void getListPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String url = "/";
		HttpSession session = request.getSession();
		User user = new User();
		if (session.getAttribute("Page") == "logInController" && session.getAttribute("Verification") == "Yes") {

			user = (User) session.getAttribute("USER");
			// System.out.print(user.getEmail()+ user.getId());
			if (user != null) {
				//List<Post> posts = Post.readAllPersonalPost(2);
				// request.setAttribute("listpost", posts);
				// url="/users/profile.jsp";
			}
		} else {
			// url= "/logInController/logInController.jsp";

		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getListPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

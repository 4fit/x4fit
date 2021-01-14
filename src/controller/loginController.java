package controller;

import model.Account;
import model.Authenticator;
import model.Model;
import model.Post;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginController() {
		super();
	}

	// Kiểm tra đăng nhập và trả lại thông tin user
	public int Login(String username, String password) {
		Document doc = Model.ACCOUNT.find(Filters.eq("username", username)).first();
		if (doc != null) {
			
			String _password_ = doc.getString("password");
			String hashed_password = DigestUtils.sha256Hex(password);
			System.out.print(hashed_password +" AND " +_password_ );
			if (hashed_password.equals(_password_))
			{
				//Đăng nhập thành công
				int userID = doc.getInteger("user_id");
				return userID;
			}
			else
				return -1;
		} return -1;
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username==null || password == null)
		{
			String url = "login/login.jsp";
			response.sendRedirect(url);
			return;
		}
		
		int userID = Login(username, password);
		if ( userID >= 0) {
			//Lưu cookie
			String selector = RandomStringUtils.randomAlphanumeric(12);
			String rawValidator = RandomStringUtils.randomAlphanumeric(64);
			String hashedValidator = DigestUtils.sha256Hex(rawValidator);
			
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("selector"))
				{
					c.setMaxAge(0);
					response.addCookie(c);
				}
				if (c.getName().equals("validator"))
				{
					c.setMaxAge(0);
					response.addCookie(c);
				}
					
			}
			Cookie cookieSelector = new Cookie("selector", selector);
			cookieSelector.setMaxAge(604800);
			 
			Cookie cookieValidator = new Cookie("validator", hashedValidator);
			cookieValidator.setMaxAge(604800);
			 
			response.addCookie(cookieSelector);
			response.addCookie(cookieValidator);
			
			System.out.print(cookieSelector.getValue() +"validator " +cookieValidator.getValue());
			
			Authenticator.Update(userID, selector, hashedValidator);
			
			User user = User.GetUserByUserID(userID);
			Account account = Account.GetAccountByUserID(userID);
			
			String url = request.getContextPath() + "/home";
			response.sendRedirect(url);
		} else {
			String url = "login/login.jsp";
			response.sendRedirect(url);
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (NoSuchAlgorithmException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

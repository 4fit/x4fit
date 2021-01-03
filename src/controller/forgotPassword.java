package controller;

import model.*;
import x4fit.Utilities;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

@WebServlet("/forgotPassword")
public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public forgotPassword() {
        super();
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String url = "";
    	// get email
    	String email = request.getParameter("email");
    	
    	///send email to user
    	
    	String to = email;
    	User dbUser = new User();
    	// thêm hàm kiểm tra email đã đăng kí rồi hay không ?
    	User userDoc  = dbUser.getUserByEmail(email);
    	if(userDoc != null)
    	{
    		// sau đó lấy user dùng email đó
        	String from  = "ngocyen174308@gmail.com";
        	String pass = "#";
        	String username = ""; //userDoc.getString("username");
        	String subject = "Change you password to X4FIT";
        	String newPass = "randomPass"; // Viết hàm tạo pass mới
        	String body = "Dear " + username + ",\n\n"
        	+ "new password for you: " + newPass;
        	boolean isBodyHTML = false;
        	
        	try {
        		
        		Utilities.sendMail(from,pass, to,  subject, body, isBodyHTML);
        		dbUser.updateNewPass(newPass, username);
        		System.out.println("sSend ddc mail");
        		url = "/detailController.jsp";
        	}catch(MessagingException e)
        	{
        		System.out.println("Khong send ddc mail");
        		System.out.println(e);
        	}
        	
    	}
    	else
    		url = "/logInController.jsp";
    	
    	RequestDispatcher d = request.getRequestDispatcher(url);
    	d.forward(request, response);
    }

    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
package controller;

import model.Account;
import model.Model;
import model.User;
import x4fit.Utilities;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

@WebServlet("/signUp")
public class signUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signUpController() {
		super();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException {
		String url = "";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int user_id;

		if(request.getParameter("userCurrentAction").equals("btn"))
			{
				user_id = (int)session.getAttribute("userID");
				String code = request.getParameter("code");
				if(isUserCode(user_id, code))
					{
					User.updateStatus(user_id);
					url = "/login/login.jsp";
					}
				else
				{

					url = "login/confirm.jsp";
				}
				
			}
		else
			
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String fullname = request.getParameter("fullname");
		
			int error = 0;
			if (username.equals("")) {
				request.setAttribute("errUsername", " have not null !");
				error = error + 1;
			}

			if (email.equals("")) {
				request.setAttribute("errEmail", " have not null !");
				error = error + 1;
			}

			if (password.equals("")) {
				request.setAttribute("errPass", " have not null !");
				error = error + 1;
			}

			if (Account.checkExitUsername(username)) {
				request.setAttribute("errUsername", "Username already exist !");
				error = error + 1;
			}

			if (Account.checkExitEmail(email)) {
				request.setAttribute("errEmail", "Email already exist !");
				error = error + 1;
			}

			
			String hashedPassword = DigestUtils.sha256Hex(password);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("email", email);
			request.setAttribute("fullname", fullname);

			if (error == 0) 
			{			
				Account.createNewAccount(username, hashedPassword, email, fullname);
				
				if (Account.checkExitUsername(username))
					{
						user_id = Account.getAccountByUsername(username).getInteger("user_id");
						url = "${pageContext.request.contextPath}/confirm.jsp";
						session.setAttribute("userID", user_id);
						sendmail(email, fullname, hashedPassword);
					}
				else
					url = "/login/signup.jsp";
			} else
				url = "/login/signup.jsp";

			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
	
	public boolean isUserCode(int user_id, String code)
	{
		Document doc = Account.getDocumentAccountByUserId(user_id);
		if(code.equals(doc.getString("password").substring(0, 5)))
			return true;
		return false;
	}
	
	public void sendmail(String email, String fullname, String hashedPassword)
	{
		String from  = "ngocyen174308@gmail.com";
    	String pass = "18110402yen";
    	String OTP = hashedPassword.substring(0, 5); // Lấy 6 số đầu trong đoạn mã hash để người dùng xác nhận
    	String subject = "Wellcome to X4FIT";
    	
    	String body = "Dear " + fullname + ",\n\n"
    	+ "Your code:" + OTP;
    	boolean isBodyHTML = false;
    	
    	try {
    		
    		Utilities.sendMail(from,pass, email,  subject, body, isBodyHTML);
    		
    		System.out.println("sSend ddc mail");
    		
    	}catch(MessagingException e)
    	{
    		System.out.println("Khong send ddc mail");
    		System.out.println(e);
    	}
    	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (NoSuchAlgorithmException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

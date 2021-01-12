package controller;

import model.Account;
import model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.UserDAO;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUp() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String url = "";
    	response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String passwordConfirm = request.getParameter("passwordConfirm");
    	String email = request.getParameter("email");
    	String name = request.getParameter("name");
    	
    	UserDAO dbUser = new UserDAO();
    	
    	int error = 0;
    	
    	if (name.equals(""))
    	{
    		request.setAttribute("errName", "Name must not null !");
    		error = error + 1;
    	}
    	
    	if (passwordConfirm.equals(""))
    	{
    		request.setAttribute("errPassConfirm", "Please comfirm your password !");
    		error = error + 1;
    	}
    	
    	if (!passwordConfirm.equals(password))
    	{
    		request.setAttribute("errPassConfirm", "Password incorrect !");
    		error = error + 1;
    	}
    	
    	if (username.equals(""))
    	{
    		request.setAttribute("errUsername", "Username must not null !");
    		error = error + 1;
    	}
    	
    	if (email.equals(""))
    	{
    		request.setAttribute("errEmail", "Email have must not null !");
    		error = error + 1;
    	}
    	
    	if (password.equals(""))
    	{
    		request.setAttribute("errPass", "Password must not null !");
    		error = error + 1;
    	}
    	
    	if(dbUser.getDocUserByEmail(email)!= null)
    	{
    		request.setAttribute("errEmail", "Email already exist !");
    		error = error + 1;
    		
    	}
    	
    	if(dbUser.getDocUserByUsername(username) != null)
    	{
    		request.setAttribute("errUsername", "Username already exist !");
    		error = error + 1;
    	}
    	
    	request.setAttribute("name", name);
    	request.setAttribute("passwordConfirm", passwordConfirm);
    	
    	request.setAttribute("username", username);
    	request.setAttribute("password", password);
    	request.setAttribute("email", email);
    	
    	if(error == 0) 	
    	{
			User acc = new User(name, username, password, email);   
	    	AccountDAO dao = new AccountDAO();
	    	dao.signUpSuccess(acc);
	    	if(dao.isLoginSuccess("User", acc) != null)
	    		url = "index.jsp";
	    	else 
	    		url = "/login/signup.jsp";
    	
    	}
    	else
    		url = "/login/signup.jsp";
    	
    	System.out.print("Đăng nhập chưa được");
    	//response.sendRedirect(url);
    	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    	dispatcher.forward(request,response );
    	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
		}
	

}

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

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException{
    	String url = "";
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	User acc = new User(username, password, email);   
    	AccountDAO dao = new AccountDAO();
    	dao.signUpSuccess(acc);
    	if(dao.isLoginSuccess("USER", acc)!=null)
    	{
    		
    		User user= dao.isLoginSuccess("USER", acc);
    		HttpSession session= request.getSession();
    		session.setAttribute("USER", user);
    		url = "users/profile.jsp";
    		System.out.print(user.getEmail());
    	}
    	else 
    		url = "/signup.jsp";
    	System.out.print("Đăng nhập chưa được");
    	response.sendRedirect(url);
    	//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    	//dispatcher.forward(request,response );
    	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			process(request, response);
		} catch (NoSuchAlgorithmException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

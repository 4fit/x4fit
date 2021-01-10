package controller;

import model.Account;
import model.Post;

import org.bson.Document;

import dao.AccountDAO;
import dao.PostDAO;
import model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
    PostDAO post = new PostDAO();
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
    	String url = "/about.jsp";
    	String username = request.getParameter("username");
        String password = request.getParameter("pass");

        AccountDAO dao = new AccountDAO();
        User userAccount = new User(username, password," ");
        //User user=new User();      
        
        HttpSession session = request.getSession();
        if(dao.isLoginSuccess("User",userAccount )!= null)
        {
       
        	User user = dao.isLoginSuccess("User",userAccount );
        	//url = "/users/profile.jsp";
        	url = "/index.jsp";
    		 session.setAttribute("USER", user);
    		 session.setAttribute("Verification","Yes");
    		 session.setAttribute("Page", "login");
        }
        else
        {
        	System.out.print("Tao toi day");
        	url = "/login/signup.jsp";
        	session.setAttribute("Verification", "No");
        }
        	
       // response.sendRedirect(url);
       RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);	       
	   dispatcher.forward(request, response);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request,response);
		} catch (NoSuchAlgorithmException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

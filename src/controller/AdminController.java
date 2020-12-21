package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAO;
import dao.UserDAO;
import model.Post;
import model.User;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
			case "/all-users":
				getAllUsers(request, response);
				break;
			case "/all-posts":
				getAllPosts(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<User> allUsers = UserDAO.getAllUsers();
		 request.setAttribute("allUsers", allUsers);
		 request.getRequestDispatcher("admin/users.jsp").forward(request, response);
	}
	
	protected void getAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Post> allPosts = PostDAO.getAllPosts();
		request.setAttribute("allPosts", allPosts);
		request.getRequestDispatcher("admin/posts.jsp").forward(request, response);
	}
}

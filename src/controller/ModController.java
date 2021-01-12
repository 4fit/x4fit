package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.User;

/**
 * Servlet implementation class adminController
 */
@WebServlet("/mod")
public class modController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modController() {
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
//			case "/accept-postController":
//				acceptPost(request, response);
			default:
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
		 List<User> allUsers = User.getAllUsers();
		 request.setAttribute("allUsers", allUsers);
		 request.getRequestDispatcher("mod/users.jsp").forward(request, response);
	}
	
	protected void getAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Post> allPosts = Post.getAllPosts();
		request.setAttribute("allPosts", allPosts);
		request.getRequestDispatcher("mod/posts.jsp").forward(request, response);
	}
	
	protected void acceptPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int postId = Integer.parseInt(request.getParameter("postId"));
//		int postId = 1;
//		if (Post.acceptPost(postId)) {
//			List<Post> allPosts = Post.getAllPosts();
//			request.setAttribute("allPosts", allPosts);
//			request.getRequestDispatcher("mod/posts.jsp").forward(request, response);
//		} else {
//			System.out.println("Đã xảy ra lỗi khi duyệt bài");
//		}
	}
}

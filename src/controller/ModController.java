package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

/**
 * Servlet implementation class ModController
 */
@WebServlet(urlPatterns = {"/mod/all-posts", "/mod/accept-posts"})
public class ModController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch (action) {
			case "/mod/all-posts":
				getAllPosts(request, response);
				break;
			case "/mod/accept-posts":
				acceptPost(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void getAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Post> allPosts = Post.getAllPosts();
		request.setAttribute("allPosts", allPosts);
		request.getRequestDispatcher("mod/posts.jsp").forward(request, response);
	}
	
	protected void acceptPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt((String)request.getParameter("postId"));
		if (Post.acceptPost(postId)) {
			List<Post> allPosts = Post.getAllPosts();
			request.setAttribute("allPosts", allPosts);
			request.getRequestDispatcher("mod/posts.jsp").forward(request, response);
		} else {
			System.out.println("Đã xảy ra lỗi khi duyệt bài");
		}
	}
}

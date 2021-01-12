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
 * Servlet implementation class AcceptPostController
 */
@WebServlet("/AcceptPostController")
public class AcceptPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String postId = (String)request.getParameter("id");
		System.out.println(postId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String postId = (String)request.getParameter("postId");
//		System.out.println(postId);
//		if (Post.acceptPost(postId)) {
//			List<Post> allPosts = Post.getAllPosts();
//			request.setAttribute("allPosts", allPosts);
//			request.getRequestDispatcher("mod/posts.jsp").forward(request, response);
//		} else {
//			System.out.println("Đã xảy ra lỗi khi duyệt bài");
//		}
	}

}

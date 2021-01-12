package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

@WebServlet("/edit")
public class editController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String p = (String) request.getParameter("p");
		Post post = Post.GetPost(p);
		String title = post.getTitle();
		String content = post.getContent();
		String category = post.getCategory();
		boolean is_public = post.getIs_public();
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("category", category);
		request.setAttribute("is_public", is_public);
		request.setAttribute("p", p);

		String url = "/posts/edit.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

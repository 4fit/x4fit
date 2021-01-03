package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

@WebServlet("/save")
public class saveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public saveController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String p = (String) request.getParameter("p"); // để biết bài viết nào được saveController
		// title
		String title = request.getParameter("title");
		// is_public
		boolean is_public = request.getParameter("is_public") != null;
		// tags
		String tags = request.getParameter("tags");
		// image
		String thumbnail_url = request.getParameter("thumbnail_url");
		// content
		String content = request.getParameter("content");

		String post_URL = Post.Update(p, title, content, is_public, thumbnail_url, tags);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("url", post_URL);
		String url = "/post";
		response.sendRedirect(request.getContextPath() + url + "?p=" + post_URL);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
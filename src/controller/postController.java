package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Post;
import model.User;

@WebServlet("/post")
public class postController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Comment> listCmts;
    private ArrayList<User> listUserCmt;
    
    public postController() {
        super();
    }

    private void GetAllComments(Post post)
    {
    	listCmts = new ArrayList<Comment>();
    	listCmts = post.GetAllComments();
    	if (listCmts.size() == 0)
    		return;
    	listUserCmt = new ArrayList<User>();
    	for (Comment comment : listCmts) {
			User user = User.GetUserByUserID(comment.getUserID());
			listUserCmt.add(user);
		}
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String p = (String) request.getParameter("p");
		HttpSession session = request.getSession();
		Post post = Post.GetPost(p);
		if (post != null)
		{
			GetAllComments(post);
			
			request.setAttribute("title", post.getTitle());
			request.setAttribute("content", post.getContent());
			request.setAttribute("category", post.getCategory());
			request.setAttribute("points", post.getPoints());
			request.setAttribute("url", p);
			request.setAttribute("comments", listCmts);
			request.setAttribute("listUserCmt", listUserCmt);
			request.setAttribute("postID", post.getID());
			
			String url = "/posts/post.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else
		{
			String url = "/404.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

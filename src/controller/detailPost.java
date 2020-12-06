package controller;

import org.bson.Document;
import org.bson.conversions.Bson;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * Servlet implementation class detailPost
 */
@WebServlet("/detailPost")
public class detailPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailPost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	/*String a = "day la tilte Post";
    	String url = "/detailPost.jsp";
    	request.setAttribute("title_post",a );*/
    	response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
    	DB_detailPost db = new DB_detailPost();
    	Post p = new Post();
    	Document post = db.getPostByIdPost(1);
    	p = db.ConverseToPost(post);
    	System.out.print(post);
    	User user = new User();
    	String tilte = p.p_title;
    	int view = p.p_views_count;
    	int clips_count = p.p_clips_count;
    	String nameAuthor = "";/* user.getUserInfo((String) post.get("user_id")).get("name").toString();*/
    	
    	if (nameAuthor == null || nameAuthor == "")
    		nameAuthor = "Name Author";
    	
    	if(tilte == null || tilte == "")
    		tilte = "Title post";
    	
    	request.setAttribute("name_author", nameAuthor);
    	request.setAttribute("title_post",tilte );
    	request.setAttribute("view_post", view);
    	request.setAttribute("Clip_post_count", clips_count);
    	//request.setAttribute("post", p);
    	
    	List<Post> listPost = new ArrayList<Post>();
    	listPost.add(p);
    	listPost.add(p);
    	
    	List<Comment> listCmt = getListComment(1);
    	Collections.reverse(listCmt); // Đảo ngược list comment
    	request.setAttribute("listCmt", listCmt);
    	request.setAttribute("listPost", listPost);
    }
    
    
    public List<Comment> getListComment(int post_id)
    {
    	DB_Comment db = new DB_Comment();
    	List<Comment> listCmt = new ArrayList<Comment>();
    	listCmt = db.getCommentByIdPost(post_id);
    	return listCmt;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

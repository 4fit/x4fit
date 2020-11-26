
package controller;

import x4fit.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import sun.security.provider.SHA;

/**
 * Servlet implementation class CreatePost
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void Create(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException 
    {
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
    	//MongoClientURI uri = new MongoClientURI(
    	//	    "mongodb://tiennhm:m1nht13n@cluster0-shard-00-00.brj3o.mongodb.net:27017,cluster0-shard-00-01.brj3o.mongodb.net:27017,cluster0-shard-00-02.brj3o.mongodb.net:27017/X4FIT?ssl=true&replicaSet=atlas-emonwf-shard-0&authSource=admin&retryWrites=true&w=majority");
		//MongoClient mongoClient = new MongoClient(uri);
		//MongoDatabase database = mongoClient.getDatabase("X4FIT");
		// Kết nối đến 1 collection cụ thể
		//MongoCollection<Document> collection = database.getCollection("POST");
		
		//Document lastInsertion = collection.find().sort(new BasicDBObject("_id", -1)).first();
		//String id = (String) lastInsertion.get("id");
		String id="123";
		//
		String title = request.getParameter("title");
		String tags = request.getParameter("tags");
		String image = request.getParameter("image");
		String contents = request.getParameter("contents");
		// slug
		LocalDateTime currentDateTime = java.time.LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String formattedDateTime = currentDateTime.format(formatter);
		String slug = "0";
		try {
			slug = x4fit.Utilities.sha1(formattedDateTime);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//user_id
		String user_id = "123";
		//transliterated
		String transliterated = x4fit.Utilities.removeAccent(title);
		//status
		String status = "public";
		//points
		String points = "0";
		//views_count
		String views_count = "0";
		//comments_count
		String comments_count="0";
		//created_at
		String created_at = formattedDateTime;
		
;		
		String url = "/post";
		response.sendRedirect(request.getContextPath() + url + "?id=" + id + transliterated);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Create(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}

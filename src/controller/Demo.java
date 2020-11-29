
package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.BSON;
import org.bson.BsonDocument;
import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//Kết nối đến CSDL
		MongoClientURI uri = new MongoClientURI(
		    "mongodb://tiennhm:m1nht13n@cluster0-shard-00-00.brj3o.mongodb.net:27017,cluster0-shard-00-01.brj3o.mongodb.net:27017,cluster0-shard-00-02.brj3o.mongodb.net:27017/X4FIT?ssl=true&replicaSet=atlas-emonwf-shard-0&authSource=admin&retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("X4FIT");
		
		// Kết nối đến 1 collection cụ thể
		MongoCollection<Document> collection = database.getCollection("POST");
		// Tạo một Document cho collection trên
		Document doc = new Document("id", "18110")
				.append("name", "Nguyễn Huỳnh Minh Tiến")
				.append("email", "ngotienhoang09@gmail.com")
				.append("class", new Document("id", "181101B")
									.append("major", "Information Technology")
									.append("faculty", "Faculty of Information Technology"));
		// Insert document vừa tạo vào collection
		collection.insertOne(doc);
		// Update 1 document có id=18110
		collection.updateOne(Filters.eq("id", "18110"), Updates.set("class.id", "181101"));
		
		// Lấy ra document đầu tiên của collection
		Document myDoc = collection.find().first();
		// Đóng kết nối đến CSDL
		// mongoClient.close();
		// Chuyển docment lấy được sang định dạng JSON
		String json = myDoc.toJson();
		// Trả về trang JSP
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

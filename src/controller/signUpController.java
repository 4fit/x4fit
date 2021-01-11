package controller;

import model.Account;
import model.Model;
import model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.bson.types.ObjectId;

@WebServlet("/signUp")
public class signUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signUpController() {
		super();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException {
		String url = "";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User();

		int error = 0;
		if (username.equals("")) {
			request.setAttribute("errUsername", " have not null !");
			error = error + 1;
		}

		if (email.equals("")) {
			request.setAttribute("errEmail", " have not null !");
			error = error + 1;
		}

		if (password.equals("")) {
			request.setAttribute("errPass", " have not null !");
			error = error + 1;
		}

		if (User.getUserByEmail(email) != null) {
			request.setAttribute("errEmail", " already exist !");
			error = error + 1;
		}

		if (User.getUserByUsername(username) != null) {
			request.setAttribute("errUsername", " already exist !");
			error = error + 1;
		}

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("email", email);

		if (error == 0) {
			User acc = null;// new User(username, password, email);
			// AccountDAO dao = new AccountDAO();
			signUpSuccess(acc);
		}
//			if (isLoginSuccess("USER", acc) != null)
//				url = "index.jsp";
//			else
//				url = "/logInController/signup.jsp";
//		} else
//			url = "/logInController/signup.jsp";

		response.sendRedirect(url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	public void signUpSuccess(User user) {
		Document doc = new Document("_id", new ObjectId());

		doc.append("id", user.getUserID());
		
		doc.append("follower", user.getFollower());
		doc.append("following", user.getFollowing());
		doc.append("clips", user.getClips());
		Model.Insert(doc, "USER");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (NoSuchAlgorithmException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
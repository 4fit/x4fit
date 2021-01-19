package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import model.Account;
import model.Report;
import model.User;
import model.UserAccount;

@WebServlet(urlPatterns = {
		"/admin/all-users", 
		"/admin/create-mod",
		"/admin/update-status",
		"/admin/all-reports",
		})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getServletPath();
		switch (action) {
			case "/admin/all-users":
				getAllUsersInfo(request, response);
				return;
			case "/admin/create-mod":
				createMod(request, response);
				return;
			case "/admin/update-status":
				updateAccountStatus(request, response);
				return;
			case "/admin/all-reports":
				getAllReports(request, response);
				return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void getAllUsersInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserAccount> allUserInfoList = UserAccount.getAllUserInfo();
		request.setAttribute("userInfoList", allUserInfoList);
		request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void getAllReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Report> allReportsList = Report.getAllReports();
			request.setAttribute("allReportsList", allReportsList);
			request.getRequestDispatcher("/admin/reports.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void createMod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)request.getParameter("username");
		String email = (String)request.getParameter("email");
		String fullname = (String)request.getParameter("fullname");
		String password = (String)request.getParameter("password");
		try {
			if (Account.checkExitEmail(email) || Account.checkExitUsername(username)) {
				String errorMessage = "Username or Email already exist!";
				request.setAttribute("errorMessage", errorMessage);
			} else {
				Account.createNewMod(username, password, email, fullname);
				System.out.println("New Mod Created!");
			}
			List<UserAccount> allUserInfoList = UserAccount.getAllUserInfo();
			request.setAttribute("userInfoList", allUserInfoList);
			request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void updateAccountStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = (String)request.getParameter("status");
		ObjectId userId = new ObjectId(request.getParameter("userId"));
		try {
			User.updateUserStatusByAccountID(userId, status);
			List<UserAccount> allUserInfoList = UserAccount.getAllUserInfo();
			request.setAttribute("userInfoList", allUserInfoList);
			request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
}

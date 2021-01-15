package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.Report;
import model.User;
import model.UserAccount;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns = {
		"/admin/all-users", 
		"/admin/create-mod",
		"/admin/update-status",
		"/admin/all-reports",
		})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void getAllUsersInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<UserAccount> allUserInfoList = UserAccount.getAllUserInfo();
			request.setAttribute("userInfoList", allUserInfoList);
			request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
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
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void updateAccountStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = (String)request.getParameter("status");
		int userId = Integer.parseInt((String)request.getParameter("userId"));
		try {
			User.updateUserStatus(userId, status);
			List<UserAccount> allUserInfoList = UserAccount.getAllUserInfo();
			request.setAttribute("userInfoList", allUserInfoList);
			request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
}

package controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Category;

import model.Post;

/**
 * Servlet implementation class ModController
 */

@WebServlet(urlPatterns = {
		"/mod/all-posts", 
		"/mod/accept-posts", 
		"/mod/all-categories",
		"/mod/add-category",
		"/mod/delete-category",
		"/mod/update-category",
		"/mod/search-category",
		"/mod/search-post"
		})

public class ModController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModController() {
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
			case "/mod/all-posts":
				getAllPosts(request, response);
				return;
			case "/mod/accept-posts":
				acceptPost(request, response);
				return;
			case "/mod/all-categories":
				getAllCategories(request, response);
				return;
			case "/mod/add-category":
				addCategory(request, response);
				return;
			case "/mod/update-category":
				updateCategory(request, response);
				return;
			case "/mod/delete-category":
				deleteCategory(request, response);
				return;
			case "/mod/search-category":
				searchCategory(request, response);
				return;
			case "/mod/search-post":
				searchPost(request, response);
				return;
			default:
				response.sendRedirect("../index.jsp");
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
	
	protected void getAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Post> allPosts = Post.getAllPosts();
			request.setAttribute("allPosts", allPosts);
			request.getRequestDispatcher("/mod/posts.jsp").forward(request, response);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = (String)request.getParameter("category-name");
		String description = (String)request.getParameter("description");
		Category category = new Category(categoryName, description);
		try {
			if (Category.existCategory(categoryName)) {
				String errorMessage = "Category name already exist!";
				request.setAttribute("errorMessage", errorMessage);
			} else {
				Category.Insert(category);
			}
			List<Category> allCategories = Category.getAllCategories();
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/mod/category.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = (String)request.getParameter("url");
		try {
			Category.Delete(url);
			List<Category> allCategories = Category.getAllCategories();
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/mod/category.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			request.getRequestDispatcher("../500.jsp").forward(request, response);
		}
	}
	
	protected void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = (String)request.getParameter("url");
		String oldName = (String)request.getParameter("oldName");
		String newName = (String)request.getParameter("category-name");
		String description = (String)request.getParameter("description");
		try {
			if (Category.existCategory(newName)) {
				String errorMessage = "Category name already exist!";
				request.setAttribute("errorMessage", errorMessage);
			} else {
				Category.Update(url, oldName, newName, description);
			}
			List<Category> allCategories = Category.getAllCategories();
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/mod/category.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			request.getRequestDispatcher("../500.jsp").forward(request, response);
		}
	}
	
	protected void getAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Category> allCategories = Category.getAllCategories();
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/mod/category.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void searchCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = (String)request.getParameter("query");
		try {
			if (query.equals("")) {
				List<Category> allCategories = Category.getAllCategories();
				request.setAttribute("allCategories", allCategories);
			} else {
				List<Category> listCategories = Category.search(query);
				request.setAttribute("allCategories", listCategories);
			}
			request.setAttribute("query", query);
			request.getRequestDispatcher("/mod/category.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}

	}
	
	protected void searchPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = (String)request.getParameter("query");
		try {
			List<Post> allPosts;
			if (query.equals("")) {
				allPosts = Post.getAllPosts();
			} else {
				allPosts = Post.search(query);
				System.out.println(allPosts);
			}
			request.setAttribute("allPosts", allPosts);
			request.setAttribute("query", query);
			request.getRequestDispatcher("/mod/posts.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
	
	protected void acceptPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt((String)request.getParameter("postId"));

		try {
			Post.acceptPost(postId);
			List<Post> allPosts = Post.getAllPosts();
			request.setAttribute("allPosts", allPosts);
			request.getRequestDispatcher("/mod/posts.jsp").forward(request, response);
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
			response.sendRedirect("../500.jsp");
		}
	}
}

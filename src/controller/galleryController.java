package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import model.Authenticator;
import model.Gallery;
import model.User;

@WebServlet("/gallery")
public class galleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public galleryController() {
        super();
    }

    private void GetGallery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	int userID = User.GetUserIDFromCookies(request.getCookies());
    	
    	Gallery gallary = Gallery.GetGallery(userID);
    	String action = request.getParameter("action");
    	List<String> images;
    	try {
    		images = gallary.getImages();
        	request.setAttribute("images_gallary", images);
        	if (action.equals("uploaded"))
        	{
        		String url = "/upload.jsp";
    			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    			dispatcher.forward(request, response);
        	}
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		GetGallery(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

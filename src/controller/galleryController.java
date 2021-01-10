package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gallery;

@WebServlet("/gallery")
public class galleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public galleryController() {
        super();
    }

    private void GetGallery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	Gallery gallary = Gallery.GetGallery(1);
    	List<String> images;
    	try {
    		images = gallary.getImages();
    		String url = "/upload.jsp";
        	request.setAttribute("images_gallary", images);
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

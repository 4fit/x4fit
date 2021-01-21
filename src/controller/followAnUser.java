package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.transport.nio.ParallelNioSender;
import org.bson.types.ObjectId;

import model.User;


@WebServlet("/followAnUser")
public class followAnUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//var mongoose = require('mongoose');
		ObjectId iduser=new ObjectId (  request.getParameter("iduser"));
		ObjectId  mainuser =new ObjectId( request.getParameter("mainuser"));
		System.out.print(request.getParameter("delete"));
		
		if(request.getParameter("delete")!=null )
			{
				System.out.print(request.getParameter("delete"));
				User.RemoveUserFromFollower(iduser, mainuser);
			}
		else
		{
			User.InsertUserToFollower(iduser, mainuser);
			System.out.print("false");
		}
		  response.setContentType("application/json");
		  response.getWriter().write("done");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

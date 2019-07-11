package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   Registration rg=new Registration();
	   if((rg.Register(request.getParameter("username"), Integer.parseInt(request.getParameter("age")),request.getParameter("password"), request.getParameter("dept"), request.getParameter("designation"))==1)){
		   RequestDispatcher rd= request.getRequestDispatcher("Success.jsp");
		   request.setAttribute("check", 0);
	     	rd.forward(request, response);
	     	
	   }
	   if((rg.Register(request.getParameter("username"), Integer.parseInt(request.getParameter("age")),request.getParameter("password"), request.getParameter("dept"), request.getParameter("designation"))==2)) {
		   RequestDispatcher rd= request.getRequestDispatcher("Success.jsp");
		   request.setAttribute("check", 1);
	       rd.forward(request, response); 
	     	
	   }
	   else {
		   RequestDispatcher rd= request.getRequestDispatcher("Failure.jsp");
	     	rd.forward(request, response);
	}
	}

}

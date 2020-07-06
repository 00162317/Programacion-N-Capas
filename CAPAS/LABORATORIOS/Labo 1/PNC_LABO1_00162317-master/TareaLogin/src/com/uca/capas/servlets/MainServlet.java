package com.uca.capas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
		doGet(request, response);
		
		String nombre ="rob", pass="123";
		
		String user = request.getParameter("nombre"), 
				contra = request.getParameter("pass");
		PrintWriter sout = response.getWriter();
		
		if(nombre.equals(user) && contra.equals(pass)){
			
			
			sout.println("<html>");
			sout.println("<body>");
			sout.println("<h1>" + "BIENVENIDO" + "</h1>");
			sout.println("</body>");
			sout.println("</html>");
		}
		else {
			sout.println("<html>");
			sout.println("<body>");
			sout.println("<h1>" + "INGRESE BIEN LAS CREDENCIALES" + "</h1>");
			sout.println("</body>");
			sout.println("</html>");
		}
		
		
	}

}

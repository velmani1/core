package com.niit.shoppingcart;

import java.io.IOException;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("doGet");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		}
	String userID= request.getParameter("userID");
	String password= request.getParameter("password");
	{
	LoginDAO DAO=new LoginDAO();
	RequestDispatcher dispatcher;
	{
	if(LoginDAO.isValidUser(userID,password)==true)
	{
		dispatcher=request.getRequestDispatcher("Home.html");
		dispatcher.forward(request,response);
	}
	else
	{
		dispatcher=request.getRequestDispatcher("Login.html");
		PrintWriter writer= response.getWriter();
		writer.append("Invalid Credentials..please try again");
		dispatcher.include(request,response);
	}		
	}
}
}

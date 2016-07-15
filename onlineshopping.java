//login.html

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>online shopping</title>
</head>
<body>
	<form action="Logincontroller" method="post">
		NAME :<input type="text" name="userid" /><br /> PASSWORD:<input
			type="password" name="password" /> <input type="submit" value="login" />
	</form>
</body>
</html>





//home.html

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>HI SIVA! WELCOME
</body>
</html>




//Logincontroller.java

package com.niit.onlineshopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Logincontroller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		loginDAO logindao = new loginDAO();
		RequestDispatcher dispatcher;
		if (logindao.iSValidUser(userid, password) == true) {
			// naviget to home.html
			dispatcher = request.getRequestDispatcher("Home.html");
			dispatcher.forward(request, response);
		} else {
			// navigate to login page itself with error message
			dispatcher = request.getRequestDispatcher("login.html");
			// to createa object in printwriterclass
			PrintWriter writer = response.getWriter();
			writer.append("invalid cretencials........... please type correctly");
			dispatcher.include(request, response);
		}
	}

}









//LoginDAO.java

package com.niit.onlineshopping;

public class loginDAO {

	public boolean iSValidUser(String userid, String password) {
		if (userid.contentEquals(password)) {
			return true;
		} else {
			return false;

		}
	}
}

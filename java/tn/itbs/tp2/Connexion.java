package tn.itbs.tp2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit?serverTimezone=UTC","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("nom")==null) {
		
		
		//1. lire les champs login et mdp
		String login = request.getParameter("login"); 
		String mdp = request.getParameter("mdp");
		//2.  vérification dans la base : SELECT
		String req = "SELECT * FROM user where login = ? and password = ?";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(req);
			pst.setString(1, login);
			pst.setString(2, mdp);
			ResultSet rs = pst.executeQuery();
			//3. s'il existe : créer une session, lui ajouter le nom/login et redirection vers menu.jsp
			if (rs.next()) {
			
				session.setAttribute("nom", login ); 
				response.sendRedirect("menu.jsp");
			}
		
			else
				response.sendRedirect("index.jsp");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			response.sendRedirect("menu.jsp");
		}
		
		
	}

}

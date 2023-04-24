

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class Traitement
 */
@WebServlet("/Traitement")
public class Traitement extends HttpServlet {
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
		int id =Integer.parseInt(request.getParameter("id"));
		
		String req = "select * from member where id=? ";
		
		try {
			PreparedStatement pst =con.prepareStatement(req);
			pst.setInt(1, id);
			
			
			pst.executeQuery();
			
				
				PrintWriter out = response.getWriter();
				out.print("mise a jour en succsee");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String nom =request.getParameter("nom");
		String date_deb =request.getParameter("date_deb");
		String date_fin =request.getParameter("date_fin");
		int phone =Integer.parseInt(request.getParameter("phone"));

		
		String req = "insert into member values (?,?,?,?,?) ";
		
		try {
			PreparedStatement pst = con.prepareStatement(req);
			pst.setInt(1, id);
			pst.setString(2, nom);
			pst.setString(3, date_deb);
			pst.setString(4, date_fin);
			pst.setInt(5, phone);

			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

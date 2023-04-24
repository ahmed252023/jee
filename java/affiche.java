

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tn.itbs.tp2.member;


/**
 * Servlet implementation class affiche
 */
@WebServlet("/affiche")
public class affiche extends HttpServlet {
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
		String req = "select * from member";
		System.out.println("ok ");

		try {
			PreparedStatement pst =con.prepareStatement(req);
			ResultSet rs = pst.executeQuery();
			ArrayList<member> tab = new ArrayList<>();
			while (rs.next()) {
				member member = new member();
				member.setId(rs.getInt("id"));
				member.setNom(rs.getString("nom"));
				member.setDate_deb(rs.getString("date_deb"));
				member.setDate_fin(rs.getString("date_fin"));
				member.setPhone(rs.getInt("phone"));
				tab.add(member);
				
				//tab.add(new member (rs.getInt("id"),rs.getString("nom"),rs.getString("date_deb"),rs.getString("date_fin"),rs.getInt("phone")));
			}
			request.setAttribute("liste", tab);
			request.getRequestDispatcher("affichage.jsp").forward(request, response);
			System.out.println("ok "+tab);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

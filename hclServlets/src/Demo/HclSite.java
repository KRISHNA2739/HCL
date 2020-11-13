package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HclSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sitename=null;
	private AtomicInteger counter=null;
	private Connection myConn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		sitename=config.getInitParameter("sitename");
		String dbUrl = "jdbc:mysql://localhost:3306/krishna";
		 String user = "client";		
		 String pass = "client";
		
		 
		try
		{
		 Class.forName("com.mysql.jdbc.Driver");
		  myConn = DriverManager.getConnection(dbUrl, user, pass);
          ps=myConn.prepareStatement("Select counter from counterdata where site = ?");

		 	ps.setString(1,sitename);
         	 rs=ps.executeQuery();
		 	 if(rs.next())
		 	 {
		 	    counter=new AtomicInteger(rs.getInt("counter"));
		 	 }
		 	 
		 	 
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		 	
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		counter.addAndGet(1);
		PrintWriter out =response.getWriter();
		out.print(counter.get()+"<br>");
		
	}
	@Override
	public void destroy() {

		System.out.println("hai");

		try {
			
			ps=myConn.prepareStatement("update counterdata set counter = ? where site = ?");
			ps.setInt(1, counter.intValue());
			ps.setString(2,sitename);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


}

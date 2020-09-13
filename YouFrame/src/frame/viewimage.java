package frame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewimage")
public class viewimage extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		try {
			ArrayList<image> list = (ArrayList<image>) daolayer.getAllImage();
			
//			System.out.println(list.get(1).tid);
			String responseData = (String)UtilityJson.getJSONFromObject(list);
//			System.out.println(responseData);
			
			response.getWriter().write(responseData);

			response.flushBuffer();
			System.out.println("success");
			

		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
}
package frame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	
	@WebServlet("/uploadimage")
	public class uploadimage extends HttpServlet {

		public static final long serialVersionUID=1L;
		
		
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
		{
			String requestdata=request.getReader().readLine();
			System.out.println("angular data="+requestdata);
			
			image p=(image) UtilityJson.getObjectFromJSON(requestdata,image.class);
//			System.out.println(p.getImg());
			
			Map<String, String> map = null;
			try
			{
				map = daolayer.addimage(p);
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			
			String responsedata = (String) UtilityJson.getJSONFromObject(map);
			
			response.getWriter().write(responsedata);
			
			response.flushBuffer();
		}
			

}

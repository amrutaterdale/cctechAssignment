package frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;




public class daolayer {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youframe", "root", "root");
		return con;
	}
	
	public static Map<String, String> addimage(image p) throws ClassNotFoundException, SQLException, IOException {

		Connection con = getConnection();
		System.out.println("hi");

//		File myfile=new File(p.getImage());
//		FileInputStream fin=new FileInputStream(myfile);
		
		PreparedStatement ps = con.prepareStatement("insert into image1(image) values(?)");
        String image= p.getImg();
//        int id=p.getId();

		ps.setString(1,image);
//		ps.setObject(2,id);

		int status = ps.executeUpdate();
		System.out.println(status);

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}
	
	public static ArrayList<image> getAllImage() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from image1 order by id desc");
		ResultSet rs=ps.executeQuery();
		
		ArrayList<image>li=new ArrayList<>();
		 while(rs.next())
		 {
			 image p=new image();
			 System.out.println(rs.getString(1));
			 
			 p.setImg(rs.getString(1));
			 p.setId(rs.getInt(2));
//			 p.setCompany(rs.getString(3));
//			 p.setQuantity(rs.getString(4));
//			 p.setRate(rs.getString(5));
			 
			 li.add(p);
		 }
		 
		 return li;
		
		
	}
	
	
}
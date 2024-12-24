package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {
	public int k=0;
	public int insert(ProductBean pb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Product60 values(?,?,?,?)");
			ps.setString(1, pb.getpCode());
			ps.setString(2,pb.getpName());
			ps.setFloat(3,pb.getPrice());
			ps.setInt(4,pb.getQty());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
		
	}

}

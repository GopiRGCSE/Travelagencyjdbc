package dao;

import java.sql.*;
import connectionManager.ConnectionManager;
import model.Product;

public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		int ID=p.getId();
		String Name=p.getName();
		String Bookingdate=p.getBookingdate();
		String Travellingdate=p.getTravellingdate();
		String Travelplace=p.getTravelplace();
		String Checkin=p.getCheckin();
		String Checkout=p.getCheckout();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into product values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,ID);
		ps.setString(2, Name);
		ps.setString(3,Bookingdate);
		ps.setString(4, Travellingdate);
		ps.setString(5,Travelplace);
		ps.setString(6,Checkin);
		ps.setString(7, Checkout);
		
		ps.executeUpdate();
		
		conm.closeConnection();
	}
	
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		while(rs.next())
		{
			System.out.println(rs.getInt("ID")+" | "+rs.getString("Name")+" | "+rs.getString("Bookingdate")+" | "+rs.getString("Travellingdate")+" | "+rs.getString("Travelplace")+" | "+rs.getString("Checkin")+ " | "+rs.getString("Checkout"));
		}
	}
	
	
}

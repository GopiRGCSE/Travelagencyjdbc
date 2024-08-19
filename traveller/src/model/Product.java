package model;

public class Product {



	private int ID;
	private String UserName;
	private String Bookingdate;
	private String Travellingdate;
	private String Travelplace;
	private String Checkin;
	private String Checkout;
	public int getId() {
		return ID;
	}
	public void setId(int ID) {
		this.ID = ID;
	}
	public String getName() {
		return UserName;
	}
	public void setName(String name) {
		UserName = name;
	}
	public String getBookingdate() {
		return Bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		Bookingdate = bookingdate;
	}
	public String getTravellingdate() {
		return Travellingdate;
	}
	public void setTravellingdate(String travellingdate) {
		Travellingdate = travellingdate;
	}
	public String getTravelplace() {
		return Travelplace;
	}
	public void setTravelplace(String travelplace) {
		Travelplace = travelplace;
	}
	public String getCheckin() {
		return Checkin;
	}
	public void setCheckin(String checkin) {
		Checkin = checkin;
	}
	public String getCheckout() {
		return Checkout;
	}
	public void setCheckout(String checkout) {
		Checkout = checkout;
	}
	
	

	
}

package Controller;
import java.sql.SQLException;
import java.util.Scanner;
import model.Login;
import model.Product;
import dao.LoginDAO;
import dao.ProductDAO;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc = new Scanner(System.in);
		int choice,product;
		
		Login l = new Login();
		LoginDAO ldao = new LoginDAO();
		Product p = new Product();
		ProductDAO pdao = new ProductDAO();
		
		do
		{
			System.out.println("1. Traveller\n2. Checker\n3. Exit");
			System.out.println("*****************************************************");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Traveller Login!!!");
				System.out.println("Enter the username");
				String username = sc.next();
				System.out.println("Enter the password");
				String password = sc.next();
				l.setUsername(username);
				l.setPass(password);
				if(ldao.loginValidation(l))
				{
					System.out.println("Admin successfully logged in!!!");
					do
					{
						System.out.println("*****************************************************");
						System.out.println("1. Modify date\n2. Display \n3. Logout");
						System.out.println("*****************************************************");
						System.out.println("Enter your choice");
						product = sc.nextInt();
						switch(product)
						{
						case 1:
							System.out.println("Change Travellingdate");
							System.out.println("Enter ID");
							int ID = sc.nextInt();
							System.out.println("Enter  UserName");
							String UserName = sc.next();
							System.out.println("Enter Bookingdate");
							String Travellingdate = sc.nextLine();
							System.out.println("Enter Travellingdate");
							String Bookingdate = sc.nextLine();
							System.out.println("Enter Travellingplace");
							String Travellingplace =sc.nextLine();
							System.out.println("Enter checkin date and time");
							String checkin = sc.nextLine();
							System.out.println("Enter checkout date and time");
							String checkout = sc.nextLine();
							p.setid(ID);
							p.setUserName(UserName);
							p.setbookingdate(Bookingdate);
							p.setdate(Travellingdate);
							p.setTravellingplace(Travellingplace);
							p.setcheckindate(checkin);
							p.setcheckoutdate(checkout);
							pdao.addProduct(p);
							System.out.println("Changes added Successfully!!!");
							break;
						case 2:
							System.out.println("Travelling details are below:");
							pdao.display();
							break;
						case 3:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(product!=3);
				}
				else
				{
					System.out.println(" failed to login!!!\nInvalid Username/Password");
				}
				break;
			case 2:
				System.out.println("Checker Login!!!");
				System.out.println("Enter the username");
				String username1 = sc.next();
				System.out.println("Enter the password");
				String password1 = sc.next();
				l.setUsername(username1);
				l.setPass(password1);
				if(ldao.loginValidation(l))
				{
					System.out.println("Agent successfully logged in!!!");
					do
					{
						System.out.println("*****************************************************");
						System.out.println("1. Display \n2. Logout");
						System.out.println("*****************************************************");
						System.out.println("Enter your choice");
						product = sc.nextInt();
						switch(product)
						{
						case 1:
							System.out.println("Traveller details are below:");
							pdao.display();
							break;
						case 2:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(product!=3);
				}
				else
				{
					System.out.println("Traveller failed to login!!!\nInvalid Username/Password");
				}
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
	}
}
package hibernate_user.controller;

import java.util.Scanner;
import hibernate_user.User;
import hibernate_user.dao.UserDao;

public class Controller {
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Press \n1.Signup \n2.Login");
	User user = new User();
	UserDao dao = new UserDao();
	switch (scanner.nextInt()) {
	case 1:{
		System.out.println("Enter the Id: ");
    	user.setId(scanner.nextInt());
    	System.out.println("Enter the Name: ");
    	user.setName(scanner.next());
    	System.out.println("Enter the Phone: ");
    	user.setPhone(scanner.nextLong());
    	System.out.println("Enter the email: ");
    	user.setEmail(scanner.next());
    	System.out.println("Enter the Password: ");
    	user.setPassword(scanner.next());
    	dao.saveUser(user);
		break;	
	}
	case 2:{
    	
    	System.out.println("Enter the email: ");
    	String email = scanner.next();
    	System.out.println("Enter the Password: ");
        String password = scanner.next();
    	
    	User dbUser = dao.getUser(email);
    	if(dbUser!=null) {
    	   if(password.equals(dbUser.getPassword())) {
    		  System.out.println("Login SuccessFully!!");
    		  
    		  System.out.println("1.Display passwords \n2.Update passwords");
    		  switch (scanner.nextInt()) {
			case 1:{
			  	User user1 = dao.displayPasswords(email);
			  	System.out.println("The saved passwords are : ");
			  	System.out.println("Instagram : "+user.getInstagram());
			  	System.out.println("Facebook : "+user.getFacebook());
			  	System.out.println("X : "+user.getX());
			  	System.out.println("Snapchat : "+user.getSnapchat());
				break;
			}
			case 2:{
				System.out.println("Enter the Instagram Password: ");
				String insta = scanner.next();
				System.out.println("Enter the Facebook Password: ");
				String face = scanner.next();
				System.out.println("Enter the X Password: ");
				String x = scanner.next();
				System.out.println("Enter the Snapchat Password: ");
				String snap = scanner.next();
				
				dbUser.setInstagram(insta);
				dbUser.setFacebook(face);
				dbUser.setX(x);
				dbUser.setSnapchat(snap);
				User user2=dao.savePasswords(dbUser);
				if (user2!=null) {
					System.out.println("Passwords Updated");
				} else {
					System.out.println("Fail to Update Passwords");
				}
				break;
				
			}
			default:
				break;
			}
    	   }
    	   else {
    		  System.out.println("Invalid Password!!"); 
    	   }
         }
    	else {
    		System.out.println("User Not found!!");
    	}
    	break;
    }
	default:{
		System.out.println("You have entered invalid choise!");
		break;
	}
	}
  }
}

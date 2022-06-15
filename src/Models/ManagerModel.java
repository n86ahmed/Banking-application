package Models;

import java.io.File;
import java.io.FileWriter;

public class ManagerModel {

	public String AddCustomer(String User, String Pass, double Balance) {    

		try{   
			
			if(!SearchCustomer(User)) {
				
				FileWriter FW = new FileWriter("Users/" + User + ".txt");    
				FW.write(Pass + System.lineSeparator() + Balance);    
				FW.close();
				return "customer has been successfully created";
			}
			else
				return "Username already exists";
			
		}
		catch(Exception e){
			System.out.println(e);
		}    
		return "Unable to add customer";
	
	}
	public boolean SearchCustomer(String Username) throws Exception {
	
		File CustomerUserName = new File("Users/" + Username + ".txt"); 
		if(CustomerUserName.exists())
			return true;
		return false;
	
	}
	public String DeleteCustomer(String Username) throws Exception {
	
		File CustomerUserName = new File("Users/" + Username + ".txt"); 
		if(CustomerUserName.delete())
			return "Successfullly deleted customer";
		return "Customer doesn't exist";
		
	}
	
}

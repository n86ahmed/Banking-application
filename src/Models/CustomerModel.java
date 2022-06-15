package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerModel {

	private String Username;
	private String Password;
	private double Balance;	
	
	public CustomerModel(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}
	public boolean CheckLogin() throws Exception {
	
		File CustomerUserName = new File("Users/" + Username + ".txt"); 
		if(CustomerUserName.exists()) {
			@SuppressWarnings("resource")
			BufferedReader GetLine = new BufferedReader(new FileReader(CustomerUserName)); 
			String TEMPPassword = GetLine.readLine();
			if(Password.equals(TEMPPassword)) {
				Balance = Double.parseDouble(GetLine.readLine());
				return true;
			}
			return false;
			
		}
		return false;
		
	}
	public String DepositCash(double Cash) throws Exception {
		Balance += Cash;
		FileWriter FW = new FileWriter("Users/" + Username + ".txt");    
		FW.write(Password + System.lineSeparator() + Balance);    
		FW.close(); 
		return "Successfully deposit cash";
	}
	public String WithdrawCash(double Cash) throws Exception {
		if(Balance > Cash) {
			Balance -= Cash;			
			FileWriter FW = new FileWriter("Users/" + Username + ".txt");    
			FW.write(Password + System.lineSeparator() + Balance);    
			FW.close(); 
			return "Successfully withdraw cash";
		}
		return "Insufficient Balance";
	}
	public String PayCash(double Cash) throws Exception {
		String Statement = "Successfully paid cash";
		if(Balance > (Cash+20) &&  Cash > 50) {
			Balance -= Cash;			
			if(Balance < 10000) {
				Balance -= 20;
				Statement = Statement + " with $20 tax";
			}
			else if(Balance >= 10000 && Balance <20000) {
				Balance -= 10;
				Statement = Statement + " with $10 tax";
			}
			else
				Statement = Statement + " with $0 tax";
			FileWriter FW = new FileWriter("Users/" + Username + ".txt");    
			FW.write(Password + System.lineSeparator() + Balance);    
			FW.close(); 
			return Statement;
		}
		return "Insufficient Balance";
	}
	public double GetBalance() throws Exception {

		File CustomerUserName = new File("Users/" + Username + ".txt"); 
		BufferedReader GetLine = new BufferedReader(new FileReader(CustomerUserName)); 
		String Password = GetLine.readLine();
		Balance = Double.parseDouble(GetLine.readLine());
		return Balance;
			
	}
	
}

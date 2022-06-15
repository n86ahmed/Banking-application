package Controllers;

import Models.CustomerModel;
import Views.CustomerView;

public class CustomerController {

	CustomerModel CM;
	CustomerView CV;
	
	public CustomerController(CustomerModel CM, CustomerView CV) {		
		this.CM = CM;
		this.CV = CV;		
	}
	public CustomerModel ShowView() throws Exception {
		CV.PrintCustomerPanel(CM);
		return CM;
	}
	
}

package Controllers;

import Models.LoginModel;
import Views.LoginView;

public class LoginController {

	private LoginModel LM;
	private LoginView LV;
	
	public LoginController(LoginModel LM, LoginView LV) {
		this.LM = LM;
		this.LV = LV;
	}
	public LoginModel ShowView() {
		LV.PrintLoginScreen(LM);
		return LM;
	}
	
}

package Models;

import javafx.stage.Stage;

public class LoginModel {
	
	private Stage Window = new Stage();

	public LoginModel() {
		this.Window = new Stage();
	}
	public LoginModel(Stage Window) {
		this.Window = Window;
	}
	public Stage getWindow() {
		return Window;
	}
	public void setWindow(Stage window) {
		Window = window;
	}
	
}

import Controllers.LoginController;
import Models.LoginModel;
import Views.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String Arg[]) {
		launch(Arg);
	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {

		LoginModel LModel  = new LoginModel(PrimaryStage); 	  
	    LoginView LView = new LoginView(); 
	    LoginController LController = new LoginController(LModel, LView); 
		LController.ShowView();
		
	}
	
}

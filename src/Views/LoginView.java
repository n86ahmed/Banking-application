package Views;

import Controllers.ManagerController;
import Controllers.CustomerController;
import Models.ManagerModel;
import Models.CustomerModel;
import Models.LoginModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class LoginView {

	public void PrintLoginScreen(LoginModel LM) {
		
		Text Status = new Text();
		Status.setText("");
		
		Label LoginLbl = new Label("Login");
		LoginLbl.getStyleClass().addAll("LoginHeading");
		
		TextField Email = new TextField();
		Email.setPromptText("Email Address");
		Email.getStyleClass().add("EmailAddress");
		
		PasswordField Password = new PasswordField();
		Password.setPromptText("Password");
		Password.getStyleClass().add("Password");
		
		Button LoginBtn = new Button("Login");
		LoginBtn.getStyleClass().addAll("LoginBtn", "WhiteTextColor");
		LoginBtn.setOnAction(e -> {
			
			if(Email.getText().equals("admin") && Password.getText().equals("admin")) {

				ManagerModel AModel  = new ManagerModel(); 	  
			    ManagerView AView = new ManagerView(); 
			    ManagerController AController = new ManagerController(AModel, AView); 
				AController.ShowView();

			}	
			else {
				
				CustomerModel CModel  = new CustomerModel(Email.getText(), Password.getText()); 	  
			    CustomerView CView = new CustomerView(); 
			    CustomerController CController = new CustomerController(CModel, CView); 
				try {
					CController.ShowView();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			LM.getWindow().close();
				
		});

		Label CName = new Label("COE 528 PROJECT");
		CName.getStyleClass().add("CName");
		CName.getStyleClass().add("WhiteTextColor");
		
		Line Hr = new Line(0,0,100,0);
		Hr.setStrokeWidth(5);
		Hr.setStroke(Color.WHITE);
		Hr.getStyleClass().add("Hr");
		
		Label CDesc = new Label("Developed by Nayeem Ahmed(500902679)");
		CDesc.getStyleClass().add("WhiteTextColor");
		
		VBox CompanyInformation = new VBox();
		CompanyInformation.getChildren().addAll(CName, Hr, CDesc);
		CompanyInformation.getStyleClass().add("BlueVbox");
		CompanyInformation.setSpacing(20);

		VBox LoginBox = new VBox();
		LoginBox.getStyleClass().add("WhiteVbox");
		LoginBox.getChildren().addAll(LoginLbl, Status, Email, Password, LoginBtn);
		LoginBox.setSpacing(20);

		HBox CenterBox = new HBox();
		CenterBox.getStyleClass().add("CenterHbox");
		CenterBox.getChildren().addAll(CompanyInformation, LoginBox);
		
		BorderPane Layout = new BorderPane();
		Layout.setCenter(CenterBox);
		
		Scene Scn = new Scene(Layout, 900, 900);
		Scn.getStylesheets().add(getClass().getResource("../css/application.css").toExternalForm());
		
		LM.getWindow().setScene(Scn);
		LM.getWindow().setMaximized(true);
		LM.getWindow().show();
		
	}
}

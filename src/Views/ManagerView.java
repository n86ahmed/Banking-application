package Views;

import Controllers.LoginController;
import Models.ManagerModel;
import Models.LoginModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerView {

	private Stage Window;
	private Stage DialogStage;
	
	public void PrintAdminScreen(ManagerModel AM) {

		Window = new Stage();
		
		Button AddCustomer = new Button("Add Customer");
		AddCustomer.setOnAction(e->{
			PrintNewCustomer(AM);
		});
		
		Button DeleteCustomer = new Button("Delete Customer");
		DeleteCustomer.setOnAction(e->{
			PrintDeleteCustomer(AM);
		});
		
		Button Logout = new Button("Logout");
		Logout.setOnAction(e->{
			
			LoginModel LModel  = new LoginModel(); 	  
		    LoginView LView = new LoginView(); 
		    LoginController LController = new LoginController(LModel, LView); 
			LController.ShowView();
			Window.close();
			
		});
		
		HBox Btns = new HBox();
		Btns.getChildren().addAll(AddCustomer, DeleteCustomer, Logout);
		
		VBox Center = new VBox();
		Center.getStyleClass().add("hbox");
		Center.getChildren().addAll(Btns);
		Center.setMaxWidth(600);
		Center.setMaxHeight(600);
		Center.setSpacing(10);
		
		BorderPane Layout = new BorderPane();
		Layout.setCenter(Center);
		
		Scene Scn = new Scene(Layout, 900, 900);
		Scn.getStylesheets().add(getClass().getResource("../css/application.css").toExternalForm());

		Window.setScene(Scn);
		Window.setMaximized(true);
		Window.setTitle("Admin Panel");
		Window.show();
		
	}
	public void PrintNewCustomer(ManagerModel AM) {
		
		DialogStage = new Stage();
		
		Label CU = new Label("Customer UserName");
		Label CP = new Label("Customer Password");
		Label CB = new Label("Customer Balance");
			
		TextField CustomerUserNameInput = new TextField();
		TextField CustomerPasswordInput = new TextField();
		TextField CustomerBalanceInput = new TextField();	
		
		VBox DialogUpdateCourse = new VBox();
		DialogUpdateCourse.getChildren().addAll(CU, CustomerUserNameInput, CP, CustomerPasswordInput, CB, CustomerBalanceInput);
								
		Button AddBtn = new Button("Add");
		AddBtn.setOnAction(e->{

			String Username = CustomerUserNameInput.getText();
			String Password = CustomerPasswordInput.getText();
			double Balance = Double.parseDouble(CustomerBalanceInput.getText());
			AlertMessage(AM.AddCustomer(Username, Password, Balance)).handle(new ActionEvent());
			
		});
			
		Button CancelBtn = new Button("Cancel");
		CancelBtn.setOnAction(e->DialogStage.hide());

		HBox ButtonBox = new HBox();	
		ButtonBox.getChildren().addAll(AddBtn, CancelBtn);		
		ButtonBox.setSpacing(10);
					
		VBox Center = new VBox();
		Center.getStyleClass().add("hbox");
		Center.getChildren().addAll(DialogUpdateCourse, ButtonBox);
		Center.setMaxHeight(500);
		Center.setMaxWidth(500);
		Center.setSpacing(20);
			
		DialogStage.setResizable(false);
		Scene DialogScn = new Scene(Center, 500, 500);
		DialogScn.getStylesheets().add(getClass().getResource("../css/application.css").toExternalForm());
		DialogStage.setScene(DialogScn);
					
		DialogStage.setTitle("Add Customer");
		DialogStage.show();	
	}
	public void PrintDeleteCustomer(ManagerModel AM) {
		
		DialogStage = new Stage();
		
		Label CU = new Label("Customer UserName");
			
		TextField CustomerUserNameInput = new TextField();
		
		VBox DialogUpdateCourse = new VBox();
		DialogUpdateCourse.getChildren().addAll(CU, CustomerUserNameInput);
								
		Button DeleteBtn = new Button("Delete");
		DeleteBtn.setOnAction(e->{

			String Username = CustomerUserNameInput.getText();
			try {
				AlertMessage(AM.DeleteCustomer(Username)).handle(new ActionEvent());
			} catch (Exception e1) {
				System.out.println("Unable to delete customer");
			}
			
		});
			
		Button CancelBtn = new Button("Cancel");
		CancelBtn.setOnAction(e->DialogStage.hide());

		HBox ButtonBox = new HBox();	
		ButtonBox.getChildren().addAll(DeleteBtn, CancelBtn);		
		ButtonBox.setSpacing(10);
					
		VBox Center = new VBox();
		Center.getStyleClass().add("hbox");
		Center.getChildren().addAll(DialogUpdateCourse, ButtonBox);
		Center.setMaxHeight(500);
		Center.setMaxWidth(500);
		Center.setSpacing(20);
			
		DialogStage.setResizable(false);
		Scene DialogScn = new Scene(Center, 500, 500);
		DialogScn.getStylesheets().add(getClass().getResource("../css/application.css").toExternalForm());
		DialogStage.setScene(DialogScn);
					
		DialogStage.setTitle("Delete Customer");
		DialogStage.show();	
	}
	public EventHandler<ActionEvent> AlertMessage(String Message) {

		Alert a = new Alert(AlertType.NONE); 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) {
                a.setAlertType(AlertType.INFORMATION);
                try {
					a.setContentText(Message);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
                a.show(); 
            } 
        };
        return event;
        
	}
	
}

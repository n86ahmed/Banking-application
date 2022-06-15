package Views;

import Controllers.LoginController;
import Models.CustomerModel;
import Models.LoginModel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent; 

public class CustomerView {

	private Stage Window;
	private Stage DialogStage;
	
	public void PrintCustomerPanel(CustomerModel CM) throws Exception {
		
		if(!CM.CheckLogin()) {

			LoginModel LModel  = new LoginModel(); 	  
		    LoginView LView = new LoginView(); 
		    LoginController LController = new LoginController(LModel, LView); 
			LController.ShowView();
			return;
			
		}
		
		Window = new Stage();

		Button Deposit = new Button("Deposit");
		Deposit.setOnAction(e->{
			PrintDepositScreen(CM);
		});
		
		Button Withdraw = new Button("Withdraw");
		Withdraw.setOnAction(e->{
			PrintWithdrawScreen(CM);
		});
		
		Button GetBalanceBtn = new Button("Check Balance");
		GetBalanceBtn.setOnAction(AlertMessage("Your balance is " + CM.GetBalance()));
		
		Button OnlinePurchase = new Button("Purchase Online");
		OnlinePurchase.setOnAction(e->{
			PrintPurchaseOnlineScreen(CM);
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
		Btns.getChildren().addAll(Withdraw, Deposit, GetBalanceBtn, OnlinePurchase, Logout);
		
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
		
		Window.setMaximized(true);
		Window.setScene(Scn);
		Window.setTitle("Customer Panel");
		Window.show();
		
	}
	public void PrintWithdrawScreen(CustomerModel CM) {
		
		DialogStage = new Stage();
		
		Label CU = new Label("Enter Amount");
			
		TextField CustomerCashInput = new TextField();
		
		VBox DialogUpdateCourse = new VBox();
		DialogUpdateCourse.getChildren().addAll(CU, CustomerCashInput);
								
		Button WithdrawBtn = new Button("Withdraw");
		WithdrawBtn.setOnAction(e->{

			double Cash = Double.parseDouble(CustomerCashInput.getText());
			try {
				AlertMessage((CM.WithdrawCash(Cash))).handle(new ActionEvent());
			} catch (Exception e1) {
				System.out.println("Insufficient Funds");
			}
			DialogStage.hide();
			
		});
			
		Button CancelBtn = new Button("Cancel");
		CancelBtn.setOnAction(e->DialogStage.hide());

		HBox ButtonBox = new HBox();	
		ButtonBox.getChildren().addAll(WithdrawBtn, CancelBtn);		
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
					
		DialogStage.setTitle("Withdraw Cash");
		DialogStage.show();	
		
	}
	public void PrintDepositScreen(CustomerModel CM) {
		
		DialogStage = new Stage();
		
		Label CU = new Label("Enter Amount");
			
		TextField CustomerCashInput = new TextField();
		
		VBox DialogUpdateCourse = new VBox();
		DialogUpdateCourse.getChildren().addAll(CU, CustomerCashInput);
								
		Button DepositBtn = new Button("Deposit");
		DepositBtn.setOnAction(e->{

			double Cash = Double.parseDouble(CustomerCashInput.getText());
			try {
				AlertMessage(CM.DepositCash(Cash)).handle(new ActionEvent());
			} catch (Exception e1) {
				System.out.println("Unable to deposit");
			}
			DialogStage.hide();
			
		});
			
		Button CancelBtn = new Button("Cancel");
		CancelBtn.setOnAction(e->DialogStage.hide());

		HBox ButtonBox = new HBox();	
		ButtonBox.getChildren().addAll(DepositBtn, CancelBtn);		
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
					
		DialogStage.setTitle("Deposit Cash");
		DialogStage.show();	
		
	}
	public void PrintPurchaseOnlineScreen(CustomerModel CM) {
		
		DialogStage = new Stage();
		
		Label CU = new Label("Enter Amount to Buy Item");
			
		TextField CustomerCashInput = new TextField();
		
		VBox DialogUpdateCourse = new VBox();
		DialogUpdateCourse.getChildren().addAll(CU, CustomerCashInput);
								
		Button PayBtn = new Button("Pay");
		PayBtn.setOnAction(e->{

			double Cash = Double.parseDouble(CustomerCashInput.getText());
			try {
				AlertMessage(CM.PayCash(Cash)).handle(new ActionEvent());
			} catch (Exception e1) {
				System.out.println("Unable to deposit");
			}
			DialogStage.hide();
			
		});
			
		Button CancelBtn = new Button("Cancel");
		CancelBtn.setOnAction(e->DialogStage.hide());

		HBox ButtonBox = new HBox();	
		ButtonBox.getChildren().addAll(PayBtn, CancelBtn);		
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
					
		DialogStage.setTitle("Deposit Cash");
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

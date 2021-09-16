package MyController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root; 
	@FXML
    private TextField email_name_reg;

    @FXML
    private TextField user_name_reg;

    @FXML
    private TextField password_name_reg;

    @FXML
    private Button submit_button_reg;
    
    @FXML
    private Label error_label;
	@FXML 
	private ComboBox<String> ComboSort;
	@FXML
	private TextArea watch_list;
	@FXML
	private TextField search_textfield;
	@FXML
	private TextField username_textFiled_login;
	@FXML 
	private TextField password_textFiled_login;
	@FXML
	private Label error_textFiled_login;

	@FXML public void move_to_login_page(ActionEvent event) throws IOException {
		Admin admin = new Admin();
//    	System.out.print(email_name_reg.getText());
//    	System.out.print(user_name_reg.getText());
//    	System.out.print(password_name_reg.getText());
		if(email_name_reg.getText()=="")
			error_label.setText("Email field is Empty");
		else if(user_name_reg.getText()=="")
			error_label.setText("User Name field is Empty");
		else if(password_name_reg.getText()=="")
			error_label.setText("Password field is Empty");
		else if(admin.Registration(user_name_reg.getText(),password_name_reg.getText(),email_name_reg.getText())) {
	    	root = FXMLLoader.load(getClass().getResource("../application/login.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login Page");
			stage.show();
    	}
    	error_label.setText("User Name is already taken");
	}

	@FXML public void switch_to_login(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Login Page");
		stage.show();
	}

	@FXML public void user_login(ActionEvent event) throws IOException {
		if(username_textFiled_login.getText()=="")
			error_textFiled_login.setText("User Name field can not be empty.");
		else if(password_textFiled_login.getText()=="")
			error_textFiled_login.setText("password field can not be empty.");
		else if(!new Admin().Login(username_textFiled_login.getText(), password_textFiled_login.getText()))
			error_textFiled_login.setText("User Name and password did not Match.");
		else {
			root = FXMLLoader.load(getClass().getResource("../application/Menu.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Menu");
			stage.show();
		}
	}

	@FXML public void goToRegistrationPage(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("../application/RegistrationPage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Registration Page");
			stage.show();
	}

   
   
}



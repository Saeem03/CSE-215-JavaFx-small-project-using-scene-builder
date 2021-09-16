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
	@FXML TextField search_textfield;

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
	    	root = FXMLLoader.load(getClass().getResource("../application/Home.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    	}
    	error_label.setText("User Name is already taken");
	}

	@FXML public void switch_to_login(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML public void user_login(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/Home.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

   
   
}



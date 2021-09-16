package MyController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class UserController implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML TextField email_textField_UserPage;
	@FXML TextField passwrord_textField_UserPage;
	@FXML TextField userName_textField_UserPage; 


	@FXML public void goToMenuPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/Menu.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML public void goToLoginPage(ActionEvent event) throws IOException {
		try {
			DataFile.temp_user_record_file.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
		root = FXMLLoader.load(getClass().getResource("../application/login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Scanner sc = new Scanner(DataFile.temp_user_record_file);
			String line[] = sc.nextLine().split(",");
			userName_textField_UserPage.setText(line[0]);
			passwrord_textField_UserPage.setText(line[0]);
			email_textField_UserPage.setText(line[2]);
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

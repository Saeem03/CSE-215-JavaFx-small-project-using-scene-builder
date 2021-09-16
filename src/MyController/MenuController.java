	package MyController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MenuController{

	private Stage stage;
	private Scene scene;
	private Parent root; 

	@FXML public void goToAddBookPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/AddBook.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML public void goToSearchPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/SearchPage.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML public void goToUserInfoPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/UserInfoPage.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	@FXML public void Exit(ActionEvent event) {
		Platform.exit();
        System.exit(0);
	}

	@FXML public void goToLogOutPage(ActionEvent event) throws IOException {
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


}

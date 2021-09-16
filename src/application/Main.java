package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.*;

import MyController.DataFile;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		DataFile dataFile= new DataFile();
		dataFile.firstTempTextFill();
		dataFile.fillDataList(DataFile.temp_record_file);
		try {
			dataFile.ascendingSortById(DataFile.search_record_file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		launch(args);
	}
}


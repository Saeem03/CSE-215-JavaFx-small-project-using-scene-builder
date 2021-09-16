package MyController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SearchController implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root; 
	private Scanner sc;
    @FXML
	private ComboBox<String> ComboSort;
	@FXML
	private TextArea watch_list;
	@FXML TextField search_textfield;

	
	@FXML public void search_book(ActionEvent event) throws IOException {
		String s = search_textfield.getText().toLowerCase();
		if(s=="")
			return;
		sc = new Scanner(DataFile.temp_record_file);
		if(!sc.hasNext())
			return;
		DataFile dataFile = new DataFile();
		dataFile.fillDataList(DataFile.temp_record_file);
		System.out.println(dataFile.dataList.size());
		watch_list.setText("");
		FileWriter fw = new FileWriter(DataFile.search_record_file);
		try {
			for (int i = 0; i < dataFile.dataList.size(); i++) {
				if(dataFile.dataList.get(i).getTitle().toLowerCase().contains(s)) {
						fw.write(dataFile.dataList.get(i).commaSeperate());
						watch_list.appendText(dataFile.dataList.get(i).toString());
//						System.out.println(i);
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML public void select_sort(ActionEvent event) throws IOException {
		sc = new Scanner(DataFile.search_record_file);
		if(!sc.hasNext())return;
		watch_list.setText("");
		String s  = ComboSort.getSelectionModel().getSelectedItem().toString();
		DataFile dataFile = new DataFile();
		if(s.equals("Sort By ID (Ascending)")) {
			dataFile.ascendingSortById(DataFile.search_record_file);
			}
		else if(s.equals("Sort By ID (Descending)")) {
			dataFile.descendingSortById(DataFile.search_record_file);
			}
		else if(s.equals("Sort By Rating (Ascending)")) {
			dataFile.ascendingSortByRating(DataFile.search_record_file);
		}
		else if(s.equals("Sort By Rating (Descending)")) {
			dataFile.descendingSortById(DataFile.search_record_file);
		}
		else if(s.equals("Sort By Title (Ascending)")) {
			dataFile.ascendingSortByTitle(DataFile.search_record_file);
		}
		else if(s.equals("Sort By Title (Descending)")) {
			dataFile.descendingSortByTitle(DataFile.search_record_file);
		}
		for (int i = 0; i < dataFile.getDataList().size(); i++) {
			watch_list.appendText( dataFile.getDataList().get(i).toString()+'\n' );
		}
		sc.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList("Sort By ID (Ascending)","Sort By ID (Descending)","Sort By Title (Ascending)","Sort By Title (Descending)","Sort By Rating (Ascending)","Sort By Rating (Descending)");
		ComboSort.setItems(list);
	}

	@FXML public void backToMenu(ActionEvent event) throws IOException {
		FileWriter fw = new FileWriter(DataFile.search_record_file);
		fw.close();
		root = FXMLLoader.load(getClass().getResource("../application/Menu.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
   
   
}



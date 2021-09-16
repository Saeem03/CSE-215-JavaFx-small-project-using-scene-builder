package MyController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import application.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class BookController {
	private Stage stage;
	private Scene scene;
	private Parent root; 

	@FXML TextField title_textField_AddBook;
	@FXML TextField author_textField_AddBook;
	@FXML TextField rating_textField_AddBook;
	@FXML TextField languageCode_textField_AddBook;
	@FXML TextField ISBN_textField_AddBook;
	@FXML TextField publicationDate_textField_AddBook;
	@FXML TextField publisher_textField_AddBook;
	@FXML TextField numberOfPages_textField_AddBook;
	@FXML Label outputResult_textField_AddBook;
	@FXML public void addBookMethod() throws IOException {
		String title = title_textField_AddBook.getText();
		String author = author_textField_AddBook.getText();
		String language_code = languageCode_textField_AddBook.getText();
		String publicationDate = publicationDate_textField_AddBook.getText();
		String publisher = publisher_textField_AddBook.getText();
		
		int bookID=1;
		if(title=="") 
			title_textField_AddBook.setPromptText("Title can not be empty.");
		else if(rating_textField_AddBook.getText() == "")
			rating_textField_AddBook.setText("Rating can not be empty");
		else if(publisher=="")
			publisher_textField_AddBook.setText("Publisher can not be empty");
		else if(numberOfPages_textField_AddBook.getText()=="")
			numberOfPages_textField_AddBook.setText("Number of pages can not be empty");
		else if(ISBN_textField_AddBook.getText()=="")
			ISBN_textField_AddBook.setText("ISBN can not be empty");
		else {
			double rating = 0;
			int numberOfPages = 0 ;
			long ISBN = 0 ;
			try {
				numberOfPages = Integer.parseInt(numberOfPages_textField_AddBook.getText());
				rating = Double.parseDouble(rating_textField_AddBook.getText());
				ISBN = Long.parseLong(ISBN_textField_AddBook.getText());			
			}catch (Exception e) {
				e.printStackTrace();
			}
			Book b = new Book(bookID,title,author,rating,ISBN,language_code,numberOfPages,publicationDate,publisher);
			FileWriter fw = new FileWriter(DataFile.Books_record_file,true);
			fw.write(b.commaSeperate());
			fw.close();
			title_textField_AddBook.setText("");
			author_textField_AddBook.setText("");
			rating_textField_AddBook.setText("");
			languageCode_textField_AddBook.setText("");
			ISBN_textField_AddBook.setText("");
			publicationDate_textField_AddBook.setText("");
			publisher_textField_AddBook.setText("");
			numberOfPages_textField_AddBook.setText("");
			outputResult_textField_AddBook.setText("Book is added.");
  		}
	}
	@FXML public void backToMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../application/Menu.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

}

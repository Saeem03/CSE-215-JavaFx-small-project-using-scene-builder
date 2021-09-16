package MyController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import application.Book;


public class DataFile {
	public final static File Books_record_file = new File("books.txt");
	public final static File temp_record_file = new File("temp.txt");
	public final static File search_record_file = new File("searchInfo.txt");
	public final static File temp_search_record_file = new File("tempSearchInfo.txt");
	public final static File user_record_file = new File("userInfo.txt");
	public final static File temp_user_record_file = new File("tempUserInfo.txt");
	public ArrayList<Book> dataList;
	static Scanner sc;
	public DataFile() {
	}
	public void initializeDataFile() {
		dataList = new ArrayList<>();
		firstTempTextFill();
		fillDataList(temp_record_file);
	}
	public  void fillDataList (File file) {
		try {
			dataList = new ArrayList<>();
			sc = new Scanner(file);
			while(sc.hasNext()) {
			String words[] = sc.nextLine().split(",");
			if(words.length<9)
				continue;
			dataList.add(new Book(Integer.parseInt(words[0]),words[1],words[2],Double.parseDouble(words[3]),Long.parseLong(words[4]),words[5],Integer.parseInt(words[6]),words[7],words[8]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	public void firstTempTextFill() {
		try {
			sc = new Scanner(Books_record_file);
			FileWriter fw = new FileWriter(temp_record_file);
			sc.nextLine();
			while(sc.hasNext())
				fw.write(sc.nextLine()+'\n');
			sc.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Book searchByTitle(String title) {
		for (int i = 0; i < dataList.size(); i++) {
			if(dataList.get(i).getTitle().equalsIgnoreCase(title))
				return dataList.get(i);
		}
		return new Book();
	}
	public Book searchById(int id) {
		for (int i = 0; i < dataList.size(); i++) {
			if(dataList.get(i).getId()==id)
				return dataList.get(i);
		}
		return new Book();
	}
	public  void ascendingSortById(File file) throws IOException {
//		fillDataList(temp_record_file);
//		System.out.println(dataList.get(0).getId());
		fillDataList(file);
		Collections.sort(dataList,
			new Comparator<Book>(){
			  public int compare(Book o1, Book o2)
			  {
				  if(o1.getId()>o2.getId())
					  return 1;
				  else if(o1.getId()<o2.getId())
						  return -1;
				  return 0;
			}
		});
		FileWriter fw = new FileWriter(file);
		for(Book b : dataList)
			fw.write(b.commaSeperate());
		fw.close();
//		moveFile(DataFile.temp_search_record_file, file);
	}
	public  void descendingSortById(File file) throws IOException {
//		fillDataList(file);
		fillDataList(file);
		Collections.sort(dataList,
			new Comparator<Book>(){
			  public int compare(Book o1, Book o2)
			  {
				  if(o1.getId()<o2.getId())
					  return 1;
				  else if(o1.getId()>o2.getId())
						  return -1;
				  return 0;
			}
		});
		FileWriter fw = new FileWriter(file);
		for(Book b : dataList)
			fw.write(b.commaSeperate());
		fw.close();
	}
	public  void ascendingSortByTitle(File file) throws IOException {
		fillDataList(file);
		Collections.sort(dataList,
				new Comparator<Book>(){
			public int compare(Book o1, Book o2)
			{
				return (o1.getTitle().compareTo(o2.getTitle()));
			}
		});
		FileWriter fw = new FileWriter(file);
		for(Book b : dataList)
			fw.write(b.commaSeperate());
		fw.close();
	}
	public  void descendingSortByTitle(File file) throws IOException {
		fillDataList(file);
		Collections.sort(dataList,
				new Comparator<Book>(){
				public int compare(Book o1, Book o2)
			{
				return (o2.getTitle().compareTo(o1.getTitle()));
			}
		});
		FileWriter fw = new FileWriter(file);
		for(Book b : dataList)
			fw.write(b.commaSeperate());
		fw.close();
	}
	public  void ascendingSortByRating(File file) throws IOException {
		fillDataList(file);
		Collections.sort(dataList,
			new Comparator<Book>(){
			  public int compare(Book o1, Book o2)
			  {
				  if(o1.getAverage_rating()>o2.getAverage_rating())
					  return 1;
				  else if(o1.getAverage_rating()<o2.getAverage_rating())
						  return -1;
				  return 0;
			}
		});
		FileWriter fw = new FileWriter(file);
		for(Book b : dataList)
			fw.write(b.commaSeperate());
		fw.close();
	}
		
	public  void descendingSortByRating(File file) throws IOException {
		fillDataList(file);
		Collections.sort(dataList,
			new Comparator<Book>(){
			  public int compare(Book o1, Book o2)
			  {
				  if(o1.getAverage_rating()<o2.getAverage_rating())
					  return 1;
				  else if(o1.getAverage_rating()>o2.getAverage_rating())
						  return -1;
				  return 0;
			}
		});
		FileWriter fw = new FileWriter(file);
		for(Book b : dataList)
			fw.write(b.commaSeperate());
		fw.close();
	}
	public void moveFile(File from,File to) throws IOException {
		sc = new Scanner(from);
		FileWriter fw = new FileWriter(to);
		while(sc.hasNext()) {
			fw.append(sc.nextLine());
		}
		fw.close();
	}
	
	public  void printdataList() throws FileNotFoundException {
		sc = new Scanner(temp_record_file);
		while(sc.hasNextLine())
			System.out.println(sc.nextLine());
	}
	public ArrayList<Book> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<Book> dataList) {
		this.dataList = dataList;
	}

}


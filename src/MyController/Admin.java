package MyController;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
	Scanner sc ;
	public boolean Registration(String userName,String password,String email) throws IOException {
		sc = new Scanner(DataFile.user_record_file);
		int index=0;
		while(sc.hasNext()) {
			String[] line = sc.nextLine().split(",");
			if(line[index].equals(userName) && line[index].equals(password))
				return false;
		}
		FileWriter fw = new FileWriter(DataFile.user_record_file,true);
		fw.write(userName+","+password+","+email);
		fw.close();
		return true;
	}
	public  boolean Login(String userName,String password) throws FileNotFoundException {
		sc = new Scanner(DataFile.user_record_file);
		int index=0;
		while(sc.hasNext()) {
			String[] line = sc.nextLine().split(",");
			if(line[index].equals(userName) && line[index].equals(password))
				return true;
		}
		return false;
	}
	
}
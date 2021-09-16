package MyController;

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
		fw.write(userName+","+password+","+email+"\n");
		fw.close();
		return true;
	}
	public  boolean Login(String userName,String password) throws IOException {
		sc = new Scanner(DataFile.user_record_file);
		System.out.println(userName);
		System.out.println(password);
		while(sc.hasNext()) {
			String str = sc.nextLine();
			String[] line = str.split(",");
			if(line[0].equals(userName) && line[1].equals(password)) {
				FileWriter fw = new FileWriter(DataFile.temp_user_record_file);
				fw.write(str);
				fw.close();
				return true;
			}
		}
		return false;
	}
	
}
package apiGson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Scanner;

import com.google.gson.Gson;

public class newYourk {
	
	

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner menuescanner = new Scanner(System.in);
		boolean menueExit = true;
		do {
		for(String x:Constants.getMenuArray()) {
			System.out.println(x);
		}
		
			
			int select = menuescanner.nextInt();

			switch (select) {
			case 1:
				ArticalServer.fetchArical();
				
				break;
			case 2:
				SectionServer.fetchSection();
				break;

			case 3:
				OthureServer.fetchtAuthors();
				break;

			case 4:
				SectionServer.fetchSection();
				break;
			case 5:
				ArticalServer.insertArtical();
				break;
				
			case 6:
				OthureServer.insertAuthors();
				break;
			case 7:
				ArticalServer.addColum1();
				break;
			case 8:
				ArticalServer.addColum2();
				break;
			case 9:
				ArticalServer.prepareStatment();
				break;

			}
		} while (menueExit);

	}
}
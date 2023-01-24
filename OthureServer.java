package apiGson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import com.google.gson.Gson;

public class OthureServer {
	public static void fetchtAuthors() throws IOException, InterruptedException {
		String jsonUrl = Constants.URL_NYT_API_AUTHOR+Constants.URL_NYT_API_KEY;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		
//			for (int i=0;i<response.body().length();i++) {
			
		System.out.println("**********************************");
		System.out.println("id is" + apiResults.getId());
		System.out.println("book_author is" + apiResults.getResults()[0].getBook_author());
	
	}
	public static void insertAuthors() throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/apiNewyourk";
		String username = "root";
		String password = "root";
		String jsonUrl = Constants.URL_NYT_API_AUTHOR+Constants.URL_NYT_API_KEY;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		
//			for (int i=0;i<response.body().length();i++) {
			
		System.out.println("**********************************");
		System.out.println("id is" + apiResults.getId());
		System.out.println("book_author is" + apiResults.getResults()[0].getBook_author());
	
		String sqlInsert = "insert into section(id,book_author)"
				+ " values(" + apiResults.getResults()[0].getId() + ",'"+apiResults.getResults()[0].getBook_author()+"')";
			
	System.out.println(sqlInsert);

	// Connection class object
	Connection ccon = null;
	// Try block to check for exceptions
	try {
		Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(driver);
		ccon = DriverManager.getConnection(url, username, password);
		// Creating a statement
		java.sql.Statement st = ccon.createStatement();

		// Executing query
		int s = st.executeUpdate(sqlInsert);
		if (s >= 1)
			System.out.println("inserted successfully : " + sqlInsert);
		else
			System.out.println("insertion failed");
		// Closing the connections
		ccon.close();
	}
	// Catch block to handle exceptions
	catch (Exception ex) {
		// Display message when exceptions occurs
		System.err.println(ex);
	}
		}
	
}

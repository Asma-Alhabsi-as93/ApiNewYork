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
	

	public static void insert() throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/apiNewyourk";
		String username = "root";
		String password = "root";

		String jsonUrl = "https://api.nytimes.com/svc/topstories/v2/books.json?api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		for(int i=0;i<response.body().length();i++) {
		System.out.println("**********************************");
		System.out.print("id: " + apiResults.getId());
		System.out.print("status: " + apiResults.getStatus());
		System.out.println("copyright is" + apiResults.getCopyright());
		System.out.println("section is" + apiResults.getSection());
		System.out.println("last_updatedis" + apiResults.getLast_updated());
		System.out.println("num_results is" + apiResults.getNum_results());
//for(int i=0;i<=)
		System.out.println("resultsection is" + apiResults.getResults()[i].getResulSection());
		System.out.println("subsection is" + apiResults.getResults()[i].getSubsection());
		System.out.println("title is" + apiResults.getResults()[i].getTitle());

		String sqlInsert = "insert into apiNewyourk(id,Status,copyright, section,last_updatedis, num_results,resulSection,subsection,title)"
				+ " values(" + apiResults.getId() + ",'" + apiResults.getStatus() + "' ,'" + apiResults.getCopyright()
				+ "', '" + apiResults.getSection() + "','" + apiResults.getLast_updated() + "' ,'"+apiResults.getNum_results()+"', '"
				+ apiResults.getResults()[i].getResulSection() + "','" + apiResults.getResults()[i].getSubsection() + "','"
				+ apiResults.getResults()[i].getTitle() + "')";

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

	public static void insertArtical() throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/apiNewyourk";
		String username = "root";
		String password = "root";
		String jsonUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=UBt6ezvwrwG4h1E0UUlLv9BkrBJ4PImA";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		for(int i=0;i<response.body().length();i++) {
		System.out.println("**********************************");
		System.out.print("id: " + apiResults.getResponse().getId());
		System.out.println("pub_date is" + apiResults.getResponse().getDocs()[i].getPub_date());
		System.out.println("document_type is" + apiResults.getResponse().getDocs()[i].getDocument_type());
		System.out.println("section_name is" + apiResults.getResponse().getDocs()[i].getSection_name());
		System.out.println("subsection_name is" + apiResults.getResponse().getDocs()[i].getSubsection_name());
		
		
		String sqlInsert = "insert into aouther(id,pub_date,document_type, section_name,subsection_name)"
				+ " values(" + apiResults.getResponse().getId() + ",'" + apiResults.getResponse().getDocs()[i].getPub_date() + "' ,'" + apiResults.getResponse().getDocs()[i].getDocument_type()
				+ "', '" + apiResults.getResponse().getDocs()[i].getSection_name() + "','" + apiResults.getResponse().getDocs()[i].getSubsection_name() + "')";

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

	public static void insertAuthors() throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/apiNewyourk";
		String username = "root";
		String password = "root";
		String jsonUrl = "https://api.nytimes.com/svc/books/v3/reviews.json?author=Stephen+King&api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		
			for (int i=0;i<response.body().length();i++) {
			
		System.out.println("**********************************");
		System.out.println("id is" + apiResults.getId());
		System.out.println("book_author is" + apiResults.getResults()[i].getBook_author());
	
		String sqlInsert = "insert into section(id,book_author)"
				+ " values(" + apiResults.getResults()[i].getId() + ",'"+apiResults.getResults()[i].getBook_author()+"')";
			
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

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		boolean hasExit = true;
		do {
			System.out.println("hello");
			System.out.println("*****************");
			System.out.println("1:insert Section ");
			System.out.println("2:insert Artical ");
			System.out.println("3:insert Authors ");
			System.out.println("*****************");
			int select = sc.nextInt();

			switch (select) {

			case 1:
				insert();
				break;

			case 2:
				insertArtical();
				break;

			case 3:
				insertAuthors();
				break;

			}
		} while (hasExit);

	}
}
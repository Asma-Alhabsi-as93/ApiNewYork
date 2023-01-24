package apiGson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.gson.Gson;

public class ArticalServer {
	public static void fetchArical() throws IOException, InterruptedException {
		String jsonUrl = Constants.URL_NYT_API_ARTICAL+Constants.URL_NYT_API_KEY;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		for(int i=0;i<apiResults.getResponse().getDocs().length;i++) {
		System.out.println("**********************************");
		System.out.print("id: " + apiResults.getResponse().getId());
		System.out.println("pub_date is" + apiResults.getResponse().getDocs()[i].getPub_date());
		System.out.println("document_type is" + apiResults.getResponse().getDocs()[i].getDocument_type());
		System.out.println("section_name is" + apiResults.getResponse().getDocs()[i].getSection_name());
		System.out.println("subsection_name is" + apiResults.getResponse().getDocs()[i].getSubsection_name());
		
	}
	}
	public static void insertArtical() throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/apiNewyourk";
		String username = "root";
		String password = "root";
		String jsonUrl = Constants.URL_NYT_API_ARTICAL+Constants.URL_NYT_API_KEY;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		Gson gson = new Gson();
		Api2 apiResults = gson.fromJson(response.body(), Api2.class);
		for(int i=0;i<apiResults.getResponse().getDocs().length;i++) {
		
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
	public static void addColum1() throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/apiNewyourk";
		String username = "root";
		String password = "root";
		String jsonUrl = Constants.URL_NYT_API_ARTICAL+Constants.URL_NYT_API_KEY;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
		String sqlAdd =" ALTER TABLE aouther ADD Column section_id int";
		System.out.println(sqlAdd);

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
			int s = st.executeUpdate(sqlAdd);
			if (s >= 1)
				System.out.println("inserted successfully : " + sqlAdd);
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
		
		public static void addColum2() throws IOException, InterruptedException {
			String url = "jdbc:mysql://localhost:3306/apiNewyourk";
			String username = "root";
			String password = "root";
			String jsonUrl = Constants.URL_NYT_API_ARTICAL+Constants.URL_NYT_API_KEY;
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//		        System.out.println(response.body());
			String sqlAdd =" ALTER TABLE aouther ADD Column aouther_id int";
			System.out.println(sqlAdd);

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
				int s = st.executeUpdate(sqlAdd);
				if (s >= 1)
					System.out.println("inserted successfully : " + sqlAdd);
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
		public static void prepareStatment() throws IOException, InterruptedException {
			String url = "jdbc:mysql://localhost:3306/apiNewyourk";
			String username = "root";
			String password = "root";
			String jsonUrl = Constants.URL_NYT_API_ARTICAL+Constants.URL_NYT_API_KEY;
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(jsonUrl)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			BufferedReader buffer = new BufferedReader((new InputStreamReader(System.in)));
			System.out.println("Enter author name");
			String 	book_author=buffer.readLine();
			System.out.println("Enter document type");
			 String document_type=buffer.readLine();
			 System.out.println("Enter section name");
			 String section_name=buffer.readLine();
			 System.out.println("Enter subsection name");
			 String subsection_name=buffer.readLine();
			 System.out.println("Enter section ");
			 String section=buffer.readLine();
			 String sql="SELECT id from aouther where book_author=?";
			 String sql1="SELECT id from apinewyourk where section=?";
			 Connection ccon = null;
				// Try block to check for exceptions
				try {
					Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					ccon = DriverManager.getConnection(url, username, password);
					// Creating a statement
					PreparedStatement pstmt=ccon.prepareStatement(sql);
					PreparedStatement pstmt2=ccon.prepareStatement(sql1);
					pstmt.setString(1, book_author);
					pstmt2.setString(1, section);
					try {
						int authorId=0;
						int sectionId=0;
						ResultSet rs=pstmt.executeQuery();
						ResultSet rs2=pstmt.executeQuery();
						if(rs.next()) {
							authorId=rs.getInt("id");
						}
						if(rs2.next()) {
							sectionId=rs2.getInt("id");
						}
						if(authorId !=0 &&sectionId !=0 ) {
							try {
								 String sql3="Insert into aouther(pub_date,document_type,section_name,subsection_name,section_id,aouther_id)"
                                       +"values(?,?,?,?,?,?)";
								PreparedStatement pstmt3=ccon.prepareStatement(sql3);
								pstmt3.setDate(1, new Date(System.currentTimeMillis()));
								pstmt3.setString(2,document_type);
								pstmt3.setString(3,section_name);
								pstmt3.setString(4,subsection_name);
								pstmt3.setInt(5,authorId);
								pstmt3.setInt(6,sectionId);
								pstmt3.executeQuery();
								
							}catch(Exception e) {
								System.out.println(e);
							}
						
						}
					}catch(Exception e) {
						System.out.println(e);
				
					}
					}catch(Exception e) {
						System.out.println(e);}}}
				
				
		
	
		
	
	



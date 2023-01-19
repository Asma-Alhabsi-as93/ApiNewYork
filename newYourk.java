package apiGson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class newYourk {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 String jsonUrl = "https://api.nytimes.com/svc/topstories/v2/books.json?api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2";
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(jsonUrl))
	                .build();
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//	        System.out.println(response.body());
	        Gson gson = new Gson();
	        Api2 apiResults =gson.fromJson(response.body(), Api2.class);
	System.out.println("**********************************");
	 System.out.print("status: " + apiResults.getStatus());
	System.out.println("copyright is"+apiResults.getCopyright());
	System.out.println("section is"+apiResults.getSection());
	System.out.println("last_updatedis"+apiResults.getLast_updated());
	System.out.println("num_results is"+apiResults.getNum_results());
	System.out.println("results is"+apiResults.getResults()[0]);
	}
}

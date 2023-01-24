package apiGson;

import java.util.Arrays;
import java.util.List;

public class Constants {
public static List<String> getMenuArray(){
	List<String> menueItemList=Arrays.asList(
			"1-fetch Artical",
			"2:fetchSection",
			"3:fetchAthors",
			"4:insert Section ",
			"5:insert Artical ",
			"6:insert Authors ",
			"7:Add Colum Section_Id",
			"8:Add Colum Outher_Id",
			"9:use prepare Statment");
	return menueItemList;
}
public static String URL_NYT_API_SECTION ="https://api.nytimes.com/svc/topstories/v2/books.json?";
public static String URL_NYT_API_ARTICAL ="https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&" ;
public static String URL_NYT_API_AUTHOR = "https://api.nytimes.com/svc/books/v3/reviews.json?author=Stephen+King&";
public static String URL_NYT_API_KEY ="api-key=IO0i2IlGBNmzuUbAmzcAPdzPH5LcPss2";
}

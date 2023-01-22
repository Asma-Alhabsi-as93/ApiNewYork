package apiGson;

public class Api2 {
	int id;

	String status;
	String copyright;
	String section;
	String last_updated;
	int num_results;
	results []results;
	response response;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public response getResponse() {
		return response;
	}
	public void setResponse(response response) {
		this.response = response;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	public int getNum_results() {
		return num_results;
	}
	public void setNum_results(int num_results) {
		this.num_results = num_results;
	}
	public results[] getResults() {
		return results;
	}
	public void setResults(results[] results) {
		this.results = results;
	}
	
}
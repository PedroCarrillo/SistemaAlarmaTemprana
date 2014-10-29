package usil.proyecto.alarmatempranoa.models;

public class Recommendation {

	private Integer id;
	private String author;
	private String content;
	private String description;
	private Double latitude;
	private Double longitude;
	
	
	public Recommendation(Integer id, String author, String content, String description, Double latitude, Double longitude){
		this.id = id;
		this.author = author;
		this.content = content;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
	
}

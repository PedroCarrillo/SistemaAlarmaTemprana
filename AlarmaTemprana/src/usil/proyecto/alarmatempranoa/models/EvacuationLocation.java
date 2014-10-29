package usil.proyecto.alarmatempranoa.models;

public class EvacuationLocation {
	
	private Integer locationId;
	private String address;
	private String type; // maybe Int? depending on how the ws will manage it
	private Double longitude;
	private Double latitude;
	
	public EvacuationLocation(Integer locationId, String address, String type, Double latitude, Double longitude){
		this.locationId = locationId;
		this.address = address;
		this.type = type;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}

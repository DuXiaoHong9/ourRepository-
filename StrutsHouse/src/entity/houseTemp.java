package entity;

public class houseTemp {
	private Double firstPrice;
	private Double lastPrice;
	private Short streets;
	private Short types;
	private Double firstFloorrage;
	private Double lastFloorrage;
	private String title;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(Double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Short getStreets() {
		return streets;
	}

	public void setStreets(Short streets) {
		this.streets = streets;
	}

	public Short getTypes() {
		return types;
	}

	public void setTypes(Short types) {
		this.types = types;
	}

	public Double getFirstFloorrage() {
		return firstFloorrage;
	}

	public void setFirstFloorrage(Double firstFloorrage) {
		this.firstFloorrage = firstFloorrage;
	}

	public Double getLastFloorrage() {
		return lastFloorrage;
	}

	public void setLastFloorrage(Double lastFloorrage) {
		this.lastFloorrage = lastFloorrage;
	}
	
	public houseTemp(Double firstPrice, Double lastPrice, Short streets,
			Short types, Double firstFloorrage, Double lastFloorrage) {
		this.firstPrice = firstPrice;
		this.lastPrice = lastPrice;
		this.streets = streets;
		this.types = types;
		this.firstFloorrage = firstFloorrage;
		this.lastFloorrage = lastFloorrage;
	}

	public houseTemp() {}
	
}

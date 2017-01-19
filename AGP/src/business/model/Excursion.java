package business.model;

public class Excursion {
	private int id;
	private double price;
	private String description;
	private String name;
	private String address;
	private String type;
	private String excursion_isle;
	private Transport transport;
	private String area_longitude;
	private String area_latitude;
	private String img_activity;
	
	
	
	public Excursion() {
	}
	
	public Excursion(int id, double price, String description, String name,
			String address, String type, String excursion_isle,
			Transport transport, String area_longitude, String area_latitude,
			String img_activity) {
		this.id = id;
		this.price = price;
		this.description = description;
		this.name = name;
		this.address = address;
		this.type = type;
		this.excursion_isle = excursion_isle;
		this.transport = transport;
		this.area_longitude = area_longitude;
		this.area_latitude = area_latitude;
		this.img_activity = img_activity;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getExcursion_isle() {
		return excursion_isle;
	}
	
	public void setExcursion_isle(String excursion_isle) {
		this.excursion_isle = excursion_isle;
	}
	
	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public String getArea_longitude() {
		return area_longitude;
	}
	
	public void setArea_longitude(String area_longitude) {
		this.area_longitude = area_longitude;
	}
	
	public String getArea_latitude() {
		return area_latitude;
	}
	
	public void setArea_latitude(String area_latitude) {
		this.area_latitude = area_latitude;
	}
	
	public String getImg_activity() {
		return img_activity;
	}
	
	public void setImg_activity(String img_activity) {
		this.img_activity = img_activity;
	}

	@Override
	public String toString() {
		return "Excursion [description=" + description + ", name=" + name
				+ ", address=" + address + ", type=" + type + ", excursion_isle="
				+ excursion_isle + "]";
	}
		
}

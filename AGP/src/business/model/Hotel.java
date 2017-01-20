package business.model;


public class Hotel {
	
	private int id;
	private int stars;
	private double hotel_price;
	private String name;
	private String address;
	private String hotel_isle;
	private String hotel_longitude;
	private String hotel_latitude;
	private String img_hotel;
	

	
	public Hotel() {
	}
	
	public Hotel(int id, int stars, double price, String name, String address,
			String hotel_isle, String area_longitude, String area_latitude,
			String img_hotel) {
		this.id = id;
		this.hotel_price = price;
		this.stars = stars;
		this.name = name;
		this.address = address;
		this.hotel_isle = hotel_isle;
		this.hotel_longitude = area_longitude;
		this.hotel_latitude = area_latitude;
		this.img_hotel = img_hotel;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHotel_Price() {
		return hotel_price;
	}
	public void setHotel_Price(double price) {
		this.hotel_price = price;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
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
	public String getHotel_isle() {
		return hotel_isle;
	}
	public void setHotel_isle(String hotel_isle) {
		this.hotel_isle = hotel_isle;
	}
	public String getHotel_longitude() {
		return hotel_longitude;
	}
	public void setHotel_longitude(String area_longitude) {
		this.hotel_longitude = area_longitude;
	}
	public String getHotel_latitude() {
		return hotel_latitude;
	}
	public void setHotel_latitude(String area_latitude) {
		this.hotel_latitude = area_latitude;
	}
	public String getImg_hotel() {
		return img_hotel;
	}
	public void setImg_hotel(String img_hotel) {
		this.img_hotel = img_hotel;
	}

	@Override
	public String toString() {
		return "Hotel [price=" + hotel_price + ", stars=" + stars + ", name=" + name
				+ ", address=" + address + ", hotel_isle=" + hotel_isle + "]";
	}	
	
}

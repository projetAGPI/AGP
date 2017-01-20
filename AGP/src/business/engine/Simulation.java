package business.engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcConnection;
import business.model.Hotel;
import business.model.Excursion;
import business.model.SystemEntry;

public class Simulation {
	
	SystemEntry entry = new SystemEntry();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private List<Excursion> excursions = new ArrayList<Excursion>();
	API api= new API();
	
	public API getApi() {
		return api;
	}

	public void setApi(API api) {
		this.api = api;
	}

	public Simulation(){
		
	}
	
	private void searchById(int id) {

		try {

			String selectExcursionQuery = "SELECT * FROM excursion WHERE id_excursion=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				Excursion exc =new Excursion();
				exc.setDescription(result.getString("description"));
				exc.setName(result.getString("name"));
				exc.setAddress(result.getString("adress"));
				exc.setPrice(result.getInt("excursion_price"));
				exc.setType(result.getString("type"));
				exc.setExcursion_isle(result.getString("excursion_isle"));
				exc.setArea_latitude(result.getString("area_latitude"));
				exc.setArea_longitude(result.getString("area_longitude"));
				excursions.add(exc);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Excursion> getExcursions() {
		return api.getExcursionList();
	}

	public void setExcursions(List<Excursion> excursions) {
		api.setExcursionList((ArrayList<Excursion>) excursions);
	}

	private void searchByStar(int star) {

		try {

			String selectExcursionQuery = "SELECT * FROM hotel WHERE stars=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, star);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {

				Hotel hotel = new Hotel();

				hotel.setId(result.getInt("id_hotel"));
				hotel.setName(result.getString("hotel_name"));
				hotel.setHotel_Price(result.getInt("hotel_price"));
				hotel.setStars(result.getInt("stars"));
				hotel.setAddress(result.getString("adress"));
				hotel.setHotel_isle(result.getString("hotel_isle"));
				hotel.setHotel_latitude(result.getString("hotel_latitude"));
				hotel.setHotel_longitude(result.getString("hotel_longitude"));

				hotels.add(hotel);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}
	
	public void simulate(){
		//if(!(entry.getComfortLevel()=="")){
		int star=comfortToStar(entry.getComfortLevel());
		searchByStar(star);
		//}
	/*	else{
			searchByStar(3);
		}*/
	}
	
	public List<Hotel> simulateHotel(String comfort){
		//if(!(entry.getComfortLevel()=="")){
		int star=comfortToStar(comfort);
		searchByStar(star);
		//}
	/*	else{
			searchByStar(3);
		}*/
		return hotels;
	}
	
	public SystemEntry getEntry() {
		return entry;
	}

	public void setEntry(SystemEntry entry) {
		this.entry = entry;
	}

	public String showHotelList(){
		String s="";
		if(hotels.size()>0){
			for(int i=0;i<hotels.size();i++){
				s=s+hotels.get(i).getName()+"\n";
			}
		}
		return s;
		
	}
	
	public int comfortToStar(String comfort){
		int star=0;
		switch(comfort){
		case "Bon":
			star=3;
			break;
		case "Meilleur":
			star=4;
			break;
		}
		return star;
	}

}

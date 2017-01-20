package business.engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.model.Excursion;
import business.model.Hotel;
import jdbc.JdbcConnection;

public class SearchHotel {

	private static List<Hotel> resultat = new ArrayList<Hotel>();
	
	public static void main (String args[]){
		simulate("Bon");
	}
	
	public static void simulate(String comfort){
		int star=comfortToStar(comfort);
		searchByStar(star);
		if(resultat.size()!=0){
		for(int i=0;i<resultat.size();i++){
			System.out.println(resultat.get(i).getStars());
		}
		}
	}
	
	public static int comfortToStar(String comfort){
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

	private static void searchByStar(int star) {

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

				resultat.add(hotel);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}
/*
	private List<Hotel> searchByPrice(int price) {

		try {

			String selectExcursionQuery = "SELECT * FROM hotel WHERE hotel_price < ?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, price);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {

				Hotel hotel = new Hotel();

				hotel.setId(result.getInt("id_hotel"));
				hotel.setName(result.getString("hotel_name"));
				hotel.setStars(result.getInt("stars"));
				hotel.setAddress(result.getString("adress"));
				hotel.setHotel_isle(result.getString("hotel_isle"));
				hotel.setHotel_latitude(result.getString("hotel_latitude"));
				hotel.setHotel_longitude(result.getString("hotel_longitude"));

				resultat.add(hotel);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return resultat;

	}
*/
}

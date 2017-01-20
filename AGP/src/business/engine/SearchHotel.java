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

	private List<Hotel> resultat = new ArrayList<Hotel>();
	private List<Hotel> resultat2 = new ArrayList<Hotel>();

	private List<Hotel> SearchByStar(int star) {

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
				hotel.setPrice(result.getInt("hotel_price"));
				hotel.setAddress(result.getString("adress"));
				hotel.setHotel_isle(result.getString("hotel_isle"));
				hotel.setArea_latitude(result.getString("hotel_latitude"));
				hotel.setArea_longitude(result.getString("hotel_longitude"));

				resultat.add(hotel);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return resultat;

	}

	private List<Hotel> SearchByPrice(int price) {

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
				hotel.setArea_latitude(result.getString("hotel_latitude"));
				hotel.setArea_longitude(result.getString("hotel_longitude"));

				resultat2.add(hotel);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return resultat2;

	}

}

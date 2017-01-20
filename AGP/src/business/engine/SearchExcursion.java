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

public class SearchExcursion {
	
	private  Excursion excursion = new Excursion();

	private List<Excursion> resultat3 = new ArrayList<Excursion>();

//	public static void main(String[] args) {
//
//		SearchExcursion.SearchById(4);
//		System.out.println(excursion.getDescription());
//	}

	private  List<Excursion> SearchById(int id) {

		try {

			String selectExcursionQuery = "SELECT * FROM excursion WHERE id_excursion=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				Excursion excurtion =new Excursion();
				excursion.setDescription(result.getString("description"));
				excursion.setName(result.getString("name"));
				excursion.setAddress(result.getString("adress"));
				excursion.setPrice(result.getInt("excursion_price"));
				excursion.setType(result.getString("type"));
				excursion.setExcursion_isle(result.getString("excursion_isle"));
				excursion.setArea_latitude(result.getString("area_latitude"));
				excursion.setArea_longitude(result.getString("area_longitude"));
				
				resultat3.add(excursion);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return resultat3;
	}

}

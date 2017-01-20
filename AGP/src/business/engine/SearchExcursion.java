package business.engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.model.Excursion;
import jdbc.JdbcConnection;

public class SearchExcursion {
	
	private  Excursion excursion = new Excursion();

	private ArrayList<Excursion> excursion_list = new ArrayList<Excursion>();

//	public static void main(String[] args) {
//
//		SearchExcursion.SearchById(4);
//		System.out.println(excursion.getDescription());
//	}

	public ArrayList<Excursion> SearchById(int id,String sql) {

		try {

			String selectExcursionQuery = sql+" WHERE id_excursion=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				excursion.setDescription(result.getString("description"));
				excursion.setName(result.getString("name"));
				excursion.setAddress(result.getString("adress"));
				excursion.setPrice(result.getInt("excursion_price"));
				excursion.setType(result.getString("type"));
				excursion.setExcursion_isle(result.getString("excursion_isle"));
				excursion.setArea_latitude(result.getString("area_latitude"));
				excursion.setArea_longitude(result.getString("area_longitude"));
				
				excursion_list.add(excursion);
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return excursion_list;
	}
	
	
	public Excursion SearchById2(int id,String sql) {

		try {

			String selectExcursionQuery = sql+" WHERE id_excursion=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				excursion.setDescription(result.getString("description"));
				excursion.setName(result.getString("name"));
				excursion.setAddress(result.getString("adress"));
				excursion.setPrice(result.getInt("excursion_price"));
				excursion.setType(result.getString("type"));
				excursion.setExcursion_isle(result.getString("excursion_isle"));
				excursion.setArea_latitude(result.getString("area_latitude"));
				excursion.setArea_longitude(result.getString("area_longitude"));
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return excursion;
	}

	public ArrayList<Excursion> getExcursion_list() {
		return excursion_list;
	}

	public void setExcursion_list(ArrayList<Excursion> excursion_list) {
		this.excursion_list = excursion_list;
	}

}

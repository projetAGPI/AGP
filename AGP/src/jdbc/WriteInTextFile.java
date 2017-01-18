package jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.model.Excursion;

public class WriteInTextFile {
	 

	private void writeToFile(String path) {

		Excursion readExcursion= new Excursion();
		try {

			String selectHotelQuery = "SELECT * FROM excursion";

			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectHotelQuery);

			ResultSet result = preparedStatement.executeQuery();
			
				try{
					while (result.next()) {
						
						int id_ex=result.getInt("id_excursion");
						String desc_ex=result.getString("description");
						

						BufferedWriter bw =null;
						String filename=id_ex+".txt";
						File file = new File(path+"/"+filename);
						bw=new BufferedWriter(new FileWriter(file,true));
						bw.write(desc_ex);
					
						bw.close();
					}
					
				}
				catch(IOException e){	
				}
			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

	}

	

}

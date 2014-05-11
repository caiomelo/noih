/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Hotel;

/**
 *
 * @author RodriguesMoises
*/
public class HotelDAO {
	public static void create(Hotel hotel)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO hotel " +
			"(nome) " +
			"VALUES (?);");
			preparedStatement.setString(1, hotel.getNome());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Hotel read(long id)
	{
		Hotel hotel = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hotel WHERE id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				hotel = new Hotel();
				hotel.setNome(resultSet.getString("nome"));
				hotel.setId(id);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return hotel;
	}

	public static void update(Hotel hotel)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"UPDATE hotel SET " +
			"nome = ? " +
 			"WHERE id = ?;");
			preparedStatement.setString(1, hotel.getNome());
			preparedStatement.setLong(2, hotel.getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void delete(long id)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"DELETE FROM hotel WHERE id = ?;");
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static ArrayList<Hotel> getAll()
	{
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hotel;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Hotel hotel = new Hotel();

				hotel.setId(resultSet.getLong("id"));
				hotel.setNome(resultSet.getString("nome"));
				hotels.add(hotel);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return hotels;
	}
}
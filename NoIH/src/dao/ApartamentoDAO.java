/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Apartamento;

/**
 *
 * @author RodriguesMoises
*/
public class ApartamentoDAO {
	public static void create(Apartamento apartamento)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO apartamento " +
			"(andar, numero, tipo) " +
			"VALUES (?, ?, ?);");
			preparedStatement.setInt(1, apartamento.getAndar());
			preparedStatement.setInt(2, apartamento.getNumero());
			preparedStatement.setString(3, apartamento.getTipo());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Apartamento read(long id)
	{
		Apartamento apartamento = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM apartamento WHERE id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				apartamento = new Apartamento();
				apartamento.setId(resultSet.getLong("id"));
				apartamento.setAndar(resultSet.getInt("andar"));
				apartamento.setNumero(resultSet.getInt("numero"));
				apartamento.setTipo(resultSet.getString("tipo"));
				apartamento.setId(id);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return apartamento;
	}

	public static void update(Apartamento apartamento)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"UPDATE apartamento SET " +
			"id = ?, " +
			"andar = ?, " +
			"numero = ?, " +
			"tipo = ? " +
 			"WHERE id = ?;");
			preparedStatement.setLong(1, apartamento.getId());
			preparedStatement.setInt(2, apartamento.getAndar());
			preparedStatement.setInt(3, apartamento.getNumero());
			preparedStatement.setString(4, apartamento.getTipo());
			preparedStatement.setLong(5, apartamento.getId());

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
			"DELETE FROM apartamento WHERE id = ?;");
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

	public static ArrayList<Apartamento> getAll()
	{
		ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM apartamento;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Apartamento apartamento = new Apartamento();

				apartamento.setId(resultSet.getLong("id"));
				apartamento.setAndar(resultSet.getInt("andar"));
				apartamento.setNumero(resultSet.getInt("numero"));
				apartamento.setTipo(resultSet.getString("tipo"));
				apartamento.setId(resultSet.getLong("id"));
				apartamentos.add(apartamento);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return apartamentos;
	}
}
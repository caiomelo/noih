/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Servico;

/**
 *
 * @author RodriguesMoises
*/
public class ServicoDAO {
	public static void create(Servico servico)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO servico " +
			"(nome, valor) " +
			"VALUES (?, ?);");
			preparedStatement.setString(1, servico.getNome());
			preparedStatement.setDouble(2, servico.getValor());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Servico read(long id)
	{
		Servico servico = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM servico WHERE id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				servico = new Servico();
				servico.setNome(resultSet.getString("nome"));
				servico.setValor(resultSet.getDouble("valor"));
				servico.setId(id);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return servico;
	}

	public static void update(Servico servico)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"UPDATE servico SET " +
			"nome = ?, " +
			"valor = ? " +
 			"WHERE id = ?;");
			preparedStatement.setString(1, servico.getNome());
			preparedStatement.setDouble(2, servico.getValor());
			preparedStatement.setLong(3, servico.getId());

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
			"DELETE FROM servico WHERE id = ?;");
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

	public static ArrayList<Servico> getAll()
	{
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM servico;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Servico servico = new Servico();

				servico.setNome(resultSet.getString("nome"));
				servico.setValor(resultSet.getDouble("valor"));
				servico.setId(resultSet.getLong("id"));
				servicos.add(servico);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return servicos;
	}
}
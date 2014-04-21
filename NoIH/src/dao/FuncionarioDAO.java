/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author RodriguesMoises
*/
public class FuncionarioDAO {
	public static void create(Funcionario funcionario)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO funcionario " +
			"(id, nome, login, senha, cargo) " +
			"VALUES (?, ?, ?, ?, ?);");
			preparedStatement.setLong(1, funcionario.getId());
			preparedStatement.setString(2, funcionario.getNome());
			preparedStatement.setString(3, funcionario.getLogin());
			preparedStatement.setString(4, funcionario.getSenha());
			preparedStatement.setString(5, funcionario.getCargo());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Funcionario read(long id)
	{
		Funcionario funcionario = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM funcionario WHERE id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				funcionario = new Funcionario();
				funcionario.setId(resultSet.getLong("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setLogin(resultSet.getString("login"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setId(id);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return funcionario;
	}

	public static void update(Funcionario funcionario)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"UPDATE funcionario SET " +
			"id = ?, " +
			"nome = ?, " +
			"login = ?, " +
			"senha = ?, " +
			"cargo = ? " +
 			"WHERE id = ?;");
			preparedStatement.setLong(1, funcionario.getId());
			preparedStatement.setString(2, funcionario.getNome());
			preparedStatement.setString(3, funcionario.getLogin());
			preparedStatement.setString(4, funcionario.getSenha());
			preparedStatement.setString(5, funcionario.getCargo());
			preparedStatement.setLong(6, funcionario.getId());

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
			"DELETE FROM funcionario WHERE id = ?;");
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

	public static ArrayList<Funcionario> getAll()
	{
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM funcionario;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Funcionario funcionario = new Funcionario();

				funcionario.setId(resultSet.getLong("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setLogin(resultSet.getString("login"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setId(resultSet.getLong("id"));
				funcionarios.add(funcionario);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return funcionarios;
	}
}
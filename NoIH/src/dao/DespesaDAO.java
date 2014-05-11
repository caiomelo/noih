/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Despesa;

/**
 *
 * @author RodriguesMoises
*/
public class DespesaDAO {
	public static void create(Despesa despesa)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO despesa " +
			"(data_hora, registro, servico, valor) " +
			"VALUES (?, ?, ?, ?);");
			preparedStatement.setDate(1, new java.sql.Date(despesa.getDataHora().getTime().getTime()));
			preparedStatement.setLong(2, despesa.getRegistro().getId());
			preparedStatement.setLong(3, despesa.getServico().getId());
			preparedStatement.setDouble(4, despesa.getValor());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Despesa read(long id)
	{
		Despesa despesa = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM despesa WHERE id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				despesa = new Despesa();

				java.util.Date data_hora = resultSet.getDate("data_hora");
				java.util.GregorianCalendar data_horaCalendar = new java.util.GregorianCalendar();
				data_horaCalendar.setTime(data_hora);
				despesa.setDataHora(data_horaCalendar);

				despesa.setRegistro(RegistroDAO.read(resultSet.getLong("registro")));
				despesa.setServico(ServicoDAO.read(resultSet.getLong("servico")));
				despesa.setValor(resultSet.getDouble("valor"));
				despesa.setId(id);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return despesa;
	}

	public static void update(Despesa despesa)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"UPDATE despesa SET " +
			"data_hora = ?, " +
			"registro = ?, " +
			"servico = ?, " +
			"valor = ? " +
 			"WHERE id = ?;");
			preparedStatement.setDate(1, new java.sql.Date(despesa.getDataHora().getTime().getTime()));
			preparedStatement.setLong(2, despesa.getRegistro().getId());
			preparedStatement.setLong(3, despesa.getServico().getId());
			preparedStatement.setDouble(4, despesa.getValor());
			preparedStatement.setLong(5, despesa.getId());

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
			"DELETE FROM despesa WHERE id = ?;");
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

	public static ArrayList<Despesa> getAll()
	{
		ArrayList<Despesa> despesas = new ArrayList<Despesa>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM despesa;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Despesa despesa = new Despesa();

				java.util.Date data_hora = resultSet.getDate("data_hora");
				java.util.GregorianCalendar data_horaCalendar = new java.util.GregorianCalendar();
				data_horaCalendar.setTime(data_hora);
				despesa.setDataHora(data_horaCalendar);

				despesa.setRegistro(RegistroDAO.read(resultSet.getLong("registro")));
				despesa.setServico(ServicoDAO.read(resultSet.getLong("servico")));
				despesa.setValor(resultSet.getDouble("valor"));
				despesa.setId(resultSet.getLong("id"));
				despesas.add(despesa);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return despesas;
	}
}
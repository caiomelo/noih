/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Registro;

/**
 *
 * @author RodriguesMoises
*/
public class RegistroDAO {
	public static void create(Registro registro)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO registro " +
			"(id, checkin, checkout, reserva, hospede, apartamento, funcionario) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?);");
			preparedStatement.setLong(1, registro.getId());
			preparedStatement.setDate(2, new java.sql.Date(registro.getCheckin().getTime().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(registro.getCheckout().getTime().getTime()));
			preparedStatement.setLong(4, registro.getReserva().getId());
			preparedStatement.setLong(5, registro.getHospede().getId());
			preparedStatement.setLong(6, registro.getApartamento().getId());
			preparedStatement.setLong(7, registro.getFuncionario().getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Registro read(long id)
	{
		Registro registro = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM registro WHERE id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				registro = new Registro();
				registro.setId(resultSet.getLong("id"));

				java.util.Date checkin = resultSet.getDate("checkin");
				java.util.GregorianCalendar checkinCalendar = new java.util.GregorianCalendar();
				checkinCalendar.setTime(checkin);
				registro.setCheckin(checkinCalendar);


				java.util.Date checkout = resultSet.getDate("checkout");
				java.util.GregorianCalendar checkoutCalendar = new java.util.GregorianCalendar();
				checkoutCalendar.setTime(checkout);
				registro.setCheckout(checkoutCalendar);

				registro.setReserva(ReservaDAO.read(resultSet.getLong("reserva")));
				registro.setHospede(HospedeDAO.read(resultSet.getLong("hospede")));
				registro.setApartamento(ApartamentoDAO.read(resultSet.getLong("apartamento")));
				registro.setFuncionario(FuncionarioDAO.read(resultSet.getLong("funcionario")));
				registro.setId(id);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return registro;
	}

	public static void update(Registro registro)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
			"UPDATE registro SET " +
			"id = ?, " +
			"checkin = ?, " +
			"checkout = ?, " +
			"reserva = ?, " +
			"hospede = ?, " +
			"apartamento = ?, " +
			"funcionario = ? " +
 			"WHERE id = ?;");
			preparedStatement.setLong(1, registro.getId());
			preparedStatement.setDate(2, new java.sql.Date(registro.getCheckin().getTime().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(registro.getCheckout().getTime().getTime()));
			preparedStatement.setLong(4, registro.getReserva().getId());
			preparedStatement.setLong(5, registro.getHospede().getId());
			preparedStatement.setLong(6, registro.getApartamento().getId());
			preparedStatement.setLong(7, registro.getFuncionario().getId());
			preparedStatement.setLong(8, registro.getId());

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
			"DELETE FROM registro WHERE id = ?;");
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

	public static ArrayList<Registro> getAll()
	{
		ArrayList<Registro> registros = new ArrayList<Registro>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM registro;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Registro registro = new Registro();

				registro.setId(resultSet.getLong("id"));

				java.util.Date checkin = resultSet.getDate("checkin");
				java.util.GregorianCalendar checkinCalendar = new java.util.GregorianCalendar();
				checkinCalendar.setTime(checkin);
				registro.setCheckin(checkinCalendar);


				java.util.Date checkout = resultSet.getDate("checkout");
				java.util.GregorianCalendar checkoutCalendar = new java.util.GregorianCalendar();
				checkoutCalendar.setTime(checkout);
				registro.setCheckout(checkoutCalendar);

				registro.setReserva(ReservaDAO.read(resultSet.getLong("reserva")));
				registro.setHospede(HospedeDAO.read(resultSet.getLong("hospede")));
				registro.setApartamento(ApartamentoDAO.read(resultSet.getLong("apartamento")));
				registro.setFuncionario(FuncionarioDAO.read(resultSet.getLong("funcionario")));
				registro.setId(resultSet.getLong("id"));
				registros.add(registro);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return registros;
	}
}
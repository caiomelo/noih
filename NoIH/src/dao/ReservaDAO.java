/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Reserva;

/**
 *
 * @author RodriguesMoises
 */
public class ReservaDAO {

    public static void create(Reserva reserva) {
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reserva "
                    + "(apartamento, hospede, data_inicio, data_fim, funcionario) "
                    + "VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setLong(1, reserva.getApartamento().getId());
            preparedStatement.setLong(2, reserva.getHospede().getId());
            preparedStatement.setDate(3, new java.sql.Date(reserva.getDataInicio().getTime().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(reserva.getDataFim().getTime().getTime()));
            preparedStatement.setLong(5, reserva.getFuncionario().getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static Reserva read(long id) {
        Reserva reserva = null;

        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM reserva WHERE id = ?;");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                reserva = new Reserva();
                reserva.setApartamento(ApartamentoDAO.read(resultSet.getLong("apartamento")));
                reserva.setHospede(HospedeDAO.read(resultSet.getLong("hospede")));

                java.util.Date data_inicio = resultSet.getDate("data_inicio");
                java.util.GregorianCalendar data_inicioCalendar = new java.util.GregorianCalendar();
                data_inicioCalendar.setTime(data_inicio);
                reserva.setDataInicio(data_inicioCalendar);


                java.util.Date data_fim = resultSet.getDate("data_fim");
                java.util.GregorianCalendar data_fimCalendar = new java.util.GregorianCalendar();
                data_fimCalendar.setTime(data_fim);
                reserva.setDataFim(data_fimCalendar);

                reserva.setFuncionario(FuncionarioDAO.read(resultSet.getLong("funcionario")));
                reserva.setId(id);
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return reserva;
    }

    public static void update(Reserva reserva) {
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE reserva SET "
                    + "apartamento = ?, "
                    + "hospede = ?, "
                    + "data_inicio = ?, "
                    + "data_fim = ?, "
                    + "funcionario = ? "
                    + "WHERE id = ?;");
            preparedStatement.setLong(1, reserva.getApartamento().getId());
            preparedStatement.setLong(2, reserva.getHospede().getId());
            preparedStatement.setDate(3, new java.sql.Date(reserva.getDataInicio().getTime().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(reserva.getDataFim().getTime().getTime()));
            preparedStatement.setLong(5, reserva.getFuncionario().getId());
            preparedStatement.setLong(6, reserva.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void delete(long id) {
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM reserva WHERE id = ?;");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<Reserva> getAll() {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM reserva;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reserva reserva = new Reserva();

                reserva.setApartamento(ApartamentoDAO.read(resultSet.getLong("apartamento")));
                reserva.setHospede(HospedeDAO.read(resultSet.getLong("hospede")));

                java.util.Date data_inicio = resultSet.getDate("data_inicio");
                java.util.GregorianCalendar data_inicioCalendar = new java.util.GregorianCalendar();
                data_inicioCalendar.setTime(data_inicio);
                reserva.setDataInicio(data_inicioCalendar);


                java.util.Date data_fim = resultSet.getDate("data_fim");
                java.util.GregorianCalendar data_fimCalendar = new java.util.GregorianCalendar();
                data_fimCalendar.setTime(data_fim);
                reserva.setDataFim(data_fimCalendar);

                reserva.setFuncionario(FuncionarioDAO.read(resultSet.getLong("funcionario")));
                reserva.setId(resultSet.getLong("id"));
                reservas.add(reserva);
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return reservas;
    }
}

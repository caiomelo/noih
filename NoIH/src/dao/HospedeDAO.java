/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Hospede;

/**
 *
 * @author RodriguesMoises
 */
public class HospedeDAO {

    public static void create(Hospede hospede) {
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO hospede "
                    + "(nome, telefone, email) "
                    + "VALUES (?, ?, ?);");
            preparedStatement.setString(1, hospede.getNome());
            preparedStatement.setString(2, hospede.getTelefone());
            preparedStatement.setString(3, hospede.getEmail());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static Hospede read(long id) {
        Hospede hospede = null;

        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hospede WHERE id = ?;");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                hospede = new Hospede();
                hospede.setNome(resultSet.getString("nome"));
                hospede.setTelefone(resultSet.getString("telefone"));
                hospede.setEmail(resultSet.getString("email"));
                hospede.setId(id);
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return hospede;
    }

    public static void update(Hospede hospede) {
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE hospede SET "
                    + "nome = ?, "
                    + "telefone = ?, "
                    + "email = ? "
                    + "WHERE id = ?;");
            preparedStatement.setString(1, hospede.getNome());
            preparedStatement.setString(2, hospede.getTelefone());
            preparedStatement.setString(3, hospede.getEmail());
            preparedStatement.setLong(4, hospede.getId());

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
                    "DELETE FROM hospede WHERE id = ?;");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<Hospede> getAll() {
        ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
        Connection connection = Connector.connect(Connector.DATABASE_URL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hospede ORDER BY hospede.nome;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Hospede hospede = new Hospede();

                hospede.setNome(resultSet.getString("nome"));
                hospede.setTelefone(resultSet.getString("telefone"));
                hospede.setEmail(resultSet.getString("email"));
                hospede.setId(resultSet.getLong("id"));
                hospedes.add(hospede);
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return hospedes;
    }
}

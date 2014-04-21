/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Comentario;

/**
 *
 * @author RodriguesMoises
*/
public class ComentarioDAO {
	public static void create(Comentario comentarioTema)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comentario " +
			"(comentario, tema_id) " +
			"VALUES (?, ?);");
			preparedStatement.setString(1, comentarioTema.getComentario());
			preparedStatement.setLong(2, comentarioTema.getTemaId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static ArrayList<Comentario> getAll(long temaId)
	{
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(
                                "SELECT * FROM comentario WHERE tema_id = ?;");
                        preparedStatement.setLong(1, temaId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				Comentario comentario = new Comentario();

				comentario.setComentarioId(resultSet.getLong("comentario_id"));
				comentario.setComentario(resultSet.getString("comentario"));
				comentario.setTemaId(resultSet.getLong("tema_id"));
				comentarios.add(comentario);
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return comentarios;
	}
}
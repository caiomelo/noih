/*
 * JMomo
 */
package dao/*.DAO*/;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Tema;

/**
 *
 * @author RodriguesMoises
*/
public class TemaDAO {
	public static void create(Tema temaDiscussao)
	{
		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tema " +
			"(tema) " +
			"VALUES (?);");
			preparedStatement.setString(1, temaDiscussao.getTema());

			preparedStatement.executeUpdate();
			preparedStatement.close();
                        
                        PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT MAX(tema_id) as max FROM tema;");
                        ResultSet resultSet = preparedStatement2.executeQuery();
                        if(resultSet.next())
                        {
                            temaDiscussao.setTemaId(resultSet.getLong("max"));
                        }
                        
                        resultSet.close();
                        preparedStatement2.close();
                        
			connection.close();
			}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static Tema read(String temaStr)
	{
		Tema tema = null;

		Connection connection = Connector.connect(Connector.DATABASE_URL);
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tema WHERE tema = ?;");
			preparedStatement.setString(1, temaStr);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				tema = new Tema();
				tema.setTemaId(resultSet.getLong("tema_id"));
				tema.setTema(resultSet.getString("tema"));
			}

			preparedStatement.close();
			connection.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return tema;
	}
}
package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {
    
	private static Connection connection = null;
	private static Statement statement = null;
//	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	private final static String DATABASE_URL = "jdbc:mysql://localhost/morcego";
	private final static String JDBC_DRIVER = "org.postgresql.Driver";
	public final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/noih";
	//host defaults to localhost, pgadmin port defaults to 5432
        
        public static String DATABASE_COMPRAS_COLETIVAS = "sid_temas_comentarios";
	
	public static void connect()
	{
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL,"postgres","moises");
			statement = connection.createStatement();
		}catch(Exception e)
		{
			System.out.println("Error in method connect: " + e.getMessage());
		}
	}
        
        public static Connection connect(String database)
	{
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(database, "postgres", "moises");
			statement = connection.createStatement();
		}catch(Exception e)
		{
			System.out.println("Error in method connect: " + e.getMessage());
		}
                return connection;
	}
	
	public static ResultSet query(String string)
	{
		ResultSet resultSet = null;
		try{
			resultSet = statement.executeQuery(string);
		}catch(Exception e)
		{
			System.out.println("Error in method query: " + e.getMessage());
		}
		return resultSet;
	}
	
	public static void update(String huh)
	{
		try{
                        System.out.println(huh);
			statement.executeUpdate(huh);
		}catch(Exception e)
		{
			System.out.println("Error in method update: " + e.getMessage());
		}
	}
	
	public static void close()
	{
		try{
			connection.close();
		}catch(Exception e)
		{
			System.out.println("Error in method close: " + e.getMessage());
		}
	}
	
}

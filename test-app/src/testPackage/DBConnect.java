package testPackage;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String args[])	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData metaData = null;
		int numberOfColumns = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "dorotaj1", "J56VfF3b");
			statement = connection.createStatement();
			System.out.println("Connection Established");
			System.out.println("\nUsername Table");
			resultSet = statement.executeQuery("SELECT * FROM username");
			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();
			
			for(int i=1 ; i<=numberOfColumns ; i++)	{
				System.out.printf("%-8s\t",metaData.getColumnName(i));
			}

			System.out.println();

			while(resultSet.next()) {
				for(int i=1 ; i<=numberOfColumns ; i++) {
					System.out.printf("%-8s\t",resultSet.getObject(i));
				}

				System.out.println();
			}

			System.out.println("\nUser Table");
			resultSet = statement.executeQuery("SELECT * FROM uzytkownicy");
			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();

			for(int i=1 ; i<=numberOfColumns ; i++) {
				System.out.printf("%-8s\t",metaData.getColumnName(i));
			}

			System.out.println();



			while(resultSet.next()) {
				for(int i=1 ; i<=numberOfColumns ; i++) {
					System.out.printf("%-8s\t",resultSet.getObject(i));
				}

				System.out.println();
			}
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} catch(ClassNotFoundException classNotFound) {
			classNotFound.printStackTrace();
			System.exit(1);
		} finally {

			try {
				statement.close();
				connection.close();
			} catch(Exception exception){
				exception.printStackTrace();
				System.exit(1);
			}
		}
	}
}


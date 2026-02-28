package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import logical.User;

public class database {
	public static String url;
	
	//connection function
	public static void connect() {
		String url = "jdbc:sqlite:/home/" + User.getUser() + "/db/database.db";
	
		try (Connection conn = DriverManager.getConnection(database.url)) {
			System.out.println("Connection has been established");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}

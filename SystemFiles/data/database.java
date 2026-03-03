package data;
//didnt even use
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import logical.User;

public class Database {
	private static Connection connObject = null;
			
	public static Connection getObjConexao() {
		return connObject;
	}

	public static void connect() throws Exception {
		connObject = DriverManager.getConnection("jdbc:sqlite:/home/" + User.getUser() + "/db/database.db");
	}
	
	public static void disconnect() throws Exception {
		connObject.close();
	}


}

package getFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectToDB {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		Connection connection = DriverManager.getConnection("jdbc:db2://RDZUT01.HEB.COM:446/DB2R", "SVCT_DCM",
				"p9rty28j");

		System.out.println("Connect succesfully");
		return connection;
	}

}

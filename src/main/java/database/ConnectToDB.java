package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		String query = "select * from db2tst6.OFFER  where OFFER_ID = 1001232";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String owner = rs.getString("OWNER_UID");
			System.out.println("Basket Type = "+owner);
		}
		st.close();

	}

	protected static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		Connection connection = DriverManager.getConnection("jdbc:db2://RDZUT01.HEB.COM:446/DB2R", "SVCT_DCM",
				"p9rty28j");

		System.out.println("Connect succesfully");
		return connection;
	}
	
	public void closeConnection() {
		
	}

}

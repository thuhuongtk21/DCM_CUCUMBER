package getFromDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import stepDefinitions.ShareData;
//import getFromDB.connectToDB;

public class offerTable extends connectToDB{

	public String getDataFromDB(){
		// TODO Auto-generated method stub
		Connection connection;
		try {
			connection = getConnection();
			String query = "select * from db2tst6.OFFER where OFFER_ID = 1001232";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				ShareData.value = rs.getString("OWNER_UID");
				System.out.println("Owner = "+ShareData.value);
			}
			st.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ShareData.value;
		
		

	}

}

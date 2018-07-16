package database;

import java.sql.Connection;
import java.sql.SQLException;

public class ExcetuteSQL extends ConnectToDB{
	public void executeSQL() throws Exception, Exception  {
		Connection connection = getConnection();
	}

}

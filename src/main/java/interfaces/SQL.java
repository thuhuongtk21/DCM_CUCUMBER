package interfaces;

public class SQL {
	
	public static final String SQL_QUERY_FROM_ONE_TABLE = "select * from %s.%s where %s = %s";
	
	public static final String DYNAMIC_SQL_QUERY = "select * from %s";
	public static final String DYNAMIC_SQL_TWO_TABLES = "select * from %s.%s tb INNER JOIN %s.%s tb1 on %s WHERE tb.%s = %s";

}

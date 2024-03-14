package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseAccess {
	public static Connection getcoon() throws SQLException {
		Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String strcon="jdbc:sqlserver://LAPTOP-9JQTJS4J\\SQLEXPRESS:1433;databaseName=QuanLyBanDongHo;encrypt=true;trustServerCertificate=true;";
			conn=DriverManager.getConnection(strcon,"sa","28082002");
//			System.out.println("ok!");
		} catch (ClassNotFoundException e) {
			System.out.println("Loi!");
			System.out.println(e.getMessage()+"/n"+e.getClass()+"/n"+e.getCause());
		}
		return conn;
	}
	public static void main(String[] args) {
		DataBaseAccess d =new DataBaseAccess();
				try {
					d.getcoon();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}


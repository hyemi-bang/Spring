package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariTest {

	
	public static void main(String[] args) {
		//커넥션 풀 설정 객체
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		config.setUsername("hr");
		config.setPassword("1234");
		config.addDataSourceProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		//설정객체를 전달하여 커넥션 풀 객체를 생성 
		HikariDataSource ds = new HikariDataSource(config);
		/*
		String sql ="SELECT * FROM employees";
		try(		
				Connection conn = ds.getConnection(); // 커넥션풀로써 동작을 한다
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				System.out.printf("%d\t/%s %s\n",
						rs.getInt("employee_id"),rs.getString("first_name"),rs.getString("last_name"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		*/
	}
}

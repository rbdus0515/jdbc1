package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String sid = ":XE" ;
			String user = "kh";
			String pw = "kh1234";
			
			conn = DriverManager.getConnection(type+ip+port+sid, user, pw);
			
			System.out.print("조회할 이름 입력 : ");
			String input = sc.nextLine();
			
			String sql = "SELECT EMP_ID , EMP_NAME , SALARY FROM EMPLOYEE WHERE EMP_NAME = '" + input + "'";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("사번 : %s / 이름 : %s / 월급 : %s ", empId, empName, salary);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
			
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}














































package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex {
	
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
			
			System.out.print("검색할 DEPT_CODE를 입력하세요 : ");
			String input = sc.nextLine();
			
			String sql = "SELECT EMP_ID , EMP_NAME , DEPT_CODE , HIRE_DATE FROM EMPLOYEE WHERE DEPT_CODE = '" + input + "'";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptCode = rs.getString("DEPT_CODE");
				Date hireDate = rs.getDate("HIRE_DATE");
				
				System.out.printf("사번 : %s 이름 : %s 직급코드 : %s 입사일 : %s \n",
									empId, empName, deptCode, hireDate);
				
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







































package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc1.model.vo.Employee;

public class JDBCExample4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			System.out.print("직급명 입력 : ");
			String input1 = sc.nextLine();
			System.out.print("급여 입력 : ");
			int input2 = sc.nextInt();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; // JDBC 드라이버 종류
			String user = "kh"; // 사용자 계정
			String pw = "kh1234"; // 비밀번호
			
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "SELECT EMP_NAME , JOB_CODE , SALARY , (SALARY * 12) AS ANNUAL_INCOME"
					+ " FROM EMPLOYEE"
					+ " JOIN JOB USING(JOB_CODE)"
					+ " WHERE JOB_CODE = '" + input1 + "'"
					+ " AND  SALARY > " + input2;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			List<Employee> list = new ArrayList<Employee>();
			
			while(rs.next()) {
				String empName = rs.getString("EMP_NAEM");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				int annualIncome = rs.getInt("ANNUAL_INCOME");
				
				Employee employee = new Employee(empName, jobName, salary, annualIncome);
			}
			
			if(list.isEmpty()) {
				System.out.println("조회 결과 없음");
			} else {
				for(Employee emp : list) {
					System.out.println(emp);
				}
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

























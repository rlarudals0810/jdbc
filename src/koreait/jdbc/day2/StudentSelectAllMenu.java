package koreait.jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSelectAllMenu {
	
	public static void main(String[] args) {
		
		Connection conn = OracleUtility.getConnection();
		System.out.println(":::::::::: 모든 학생을 조회하는 메뉴 ::::::::::");
		selectAllStudent(conn);
		
		OracleUtility.close(conn);
		
	}

	private static void selectAllStudent(Connection conn) {
		
		String sql = "select * from TBL_STUDENT";
		
		try (
			PreparedStatement ps = conn.prepareStatement(sql);
		) {
			ResultSet rs = ps.executeQuery();
			System.out.println("rs 객체의 구현 클래스는 " + rs.getClass().getName());
			
			while (rs.next()) {
				System.out.println("---------------------------------------------");
				System.out.print("학번 : " + rs.getString(1));
				System.out.print(" | 이름 : " + rs.getString(2));
				System.out.print(" | 나이 : " + rs.getInt(3));
				System.out.println(" | 주소 : " + rs.getString(4));
			}	System.out.println("---------------------------------------------");
			
		} catch (SQLException e) {
			System.out.println("데이터 조회에 문제가 생겼습니다. 상세내용 - " + e.getMessage());
		}
		
	}
}

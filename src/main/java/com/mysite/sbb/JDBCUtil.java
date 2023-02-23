package com.mysite.sbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCUtil {
		//DB를 연결 설정하는 클래스
	//1. DB를 연결하는 메소드
		//static : 객체 생성 없이 클래스 이름으로 바로 호출
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		//string driver = "org.h2.Driver";
		String url = "jdbc:oracle:thin:@localhost:1522:XE";
		//String url = "jdbc:h2:tcp://localhost/~/test";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn =  DriverManager.getConnection(url, "C##HR", "1234");
			//conn = DriverManager.getconnection(url, "sa", "");
			
			System.out.println("DB에 연결 되었습니다.");	//확인 후 주석 처리
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB에 연결을 실패했습니다.");
		}
		return null;
	}
	
	
	
	//2. DB연결을 제거하는 메소드 : Connection, Statement 객체를 제거
		//Insert, Update, Delete 
	public static void close (PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				if (!pstmt.isClosed()) {	//pstmt 객체가 제거 안된 상태라면 
					pstmt.close();
					System.out.println("pstmt 객체 close()");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
					System.out.println("conn 객체 close()");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	
	//3. DB연결을 제거하는 메소드 : Connection, PreparedStatement, ResultSet 객체를 제거
		//Select
	public static void close (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed()) {
					rs.close();
					System.out.println("rs 객체 close()");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if (pstmt != null) {
			try {
				if (!pstmt.isClosed()) {	//pstmt 객체가 제거 안된 상태라면 
					pstmt.close();
					System.out.println("pstmt 객체 close()");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
					System.out.println("conn 객체 close()");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	
	public static void main(String[] args) {
		
		JDBCUtil jdbc = new JDBCUtil();
		
		jdbc.getConnection();
	}
	
	
}

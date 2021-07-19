package com.lastline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.JDBC_Close;


public class ProductDAO {
	
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@192.168.0.20:1521:xe";
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "prolast";
	private final String PASSWORD = "manager";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductDAO() {
		try {
			Class.forName(DRIVER);
//			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
//			System.out.println("[예외발생] 드라이버 로딩 실패~~~");
			e.printStackTrace();
		}
	}
	
	//---------------------------------------------------------
	//select all by name
	   public List<ProductVO> selectProductName(String pro_name){
	      List<ProductVO> list = null;
	        int result = 0;
//	        MemberMenuPrint pr = new MemberMenuPrint();

	      try {
	         //DB 연결 - Connection 객체 생성(DB와 연결된)
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         //SQL문 실행
	         StringBuilder sb = new StringBuilder();
	         sb.append("SELECT PRO_ID, PRO_NAME, TYPE, PRO_PRICE, CAFE_NAME, BEANS, PRO_INFO ");
	         sb.append("  FROM PRODUCT ");
	         sb.append(" WHERE PRO_NAME LIKE ? ");
	         sb.append(" ORDER BY PRO_ID ");
	         pstmt = conn.prepareStatement(sb.toString());
	         
	         pstmt.setString(1, pro_name);

	         rs = pstmt.executeQuery();
	         
	         //SQL문 실행 결과에 대한 처리
	         list = new ArrayList<ProductVO>();
	         while (rs.next()) {
	            list.add(new ProductVO(
	                  rs.getInt("PRO_ID"),
	                  rs.getString("PRO_NAME"),
	                  rs.getString("TYPE"),
	                  rs.getInt("PRO_PRICE"),
	                  rs.getString("CAFE_NAME"),
	                  rs.getString("BEANS"),
	                  rs.getString("PRO_INFO")
	                  ));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
	      }
	      return list;
	   }

		//---------------------------------------------------------
		//select all by beans
	   public List<ProductVO> selectProductBeans(String beans){
	      List<ProductVO> list = null;
	        int result = 0;
//	        MemberMenuPrint pr = new MemberMenuPrint();

	      try {
	         //DB 연결 - Connection 객체 생성(DB와 연결된)
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         //SQL문 실행
	         StringBuilder sb = new StringBuilder();
	         sb.append("SELECT PRO_ID, PRO_NAME, TYPE, PRO_PRICE, CAFE_NAME, BEANS, PRO_INFO ");
	         sb.append("  FROM PRODUCT ");
	         sb.append(" WHERE BEANS LIKE ? ");
	         sb.append(" ORDER BY PRO_ID ");
	         pstmt = conn.prepareStatement(sb.toString());
	         
	            pstmt.setString(1, beans);

	         rs = pstmt.executeQuery();
	         
	         //SQL문 실행 결과에 대한 처리
	         list = new ArrayList<ProductVO>();
	         while (rs.next()) {
	            list.add(new ProductVO(
	                  rs.getInt("PRO_ID"),
	                  rs.getString("PRO_NAME"),
	                  rs.getString("TYPE"),
	                  rs.getInt("PRO_PRICE"),
	                  rs.getString("CAFE_NAME"),
	                  rs.getString("BEANS"),
	                  rs.getString("PRO_INFO")
	                  ));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
	      }
	      
	      return list;
	   }
	   
	   
	   
		//---------------------------------------------------------
		//select all by type
	   public List<ProductVO> selectProductType(String type){
	      List<ProductVO> list = null;
	        int result = 0;
//	        MemberMenuPrint pr = new MemberMenuPrint();

	      try {
	         //DB 연결 - Connection 객체 생성(DB와 연결된)
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         //SQL문 실행
	         StringBuilder sb = new StringBuilder();
	         sb.append("SELECT PRO_ID, PRO_NAME, TYPE, PRO_PRICE, CAFE_NAME, BEANS, PRO_INFO ");
	         sb.append("  FROM PRODUCT ");
	         sb.append(" WHERE TYPE LIKE ? ");
	         sb.append(" ORDER BY PRO_ID ");
	         pstmt = conn.prepareStatement(sb.toString());
	         
	            pstmt.setString(1, type);

	         rs = pstmt.executeQuery();
	         
	         //SQL문 실행 결과에 대한 처리
	         list = new ArrayList<ProductVO>();
	         while (rs.next()) {
	            list.add(new ProductVO(
	                  rs.getInt("PRO_ID"),
	                  rs.getString("PRO_NAME"),
	                  rs.getString("TYPE"),
	                  rs.getInt("PRO_PRICE"),
	                  rs.getString("CAFE_NAME"),
	                  rs.getString("BEANS"),
	                  rs.getString("PRO_INFO")
	                  ));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
	      }
	      
	      return list;
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
}

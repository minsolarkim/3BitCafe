package com.lastline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.util.JDBC_Close;


public class CafeDAO {

	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@192.168.0.20:1521:xe";
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "prolast";
	private final String PASSWORD = "manager";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CafeDAO() {
		try {
			Class.forName(DRIVER);
//			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
//			System.out.println("[예외발생] 드라이버 로딩 실패~~~");
			e.printStackTrace();
		}
	}
	
	//카페정보 전체조회
	public List<CafeVO> selectAll(){
		List<CafeVO> list = null;
		
		try {
			//DB 연결 - Connection 객체 생성(DB와 연결된)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL문 실행
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT CF_ID, CF_NAME, CF_ADDRESS, CF_PHONE, CF_INFO ");
			sb.append("  FROM CAFE ");
			sb.append(" ORDER BY CF_ID ");
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			//SQL문 실행 결과에 대한 처리
			list = new ArrayList<CafeVO>();
			while (rs.next()) {

				list.add(new CafeVO(
						rs.getInt("CF_ID"),
						rs.getString("CF_NAME"),
						rs.getString("CF_ADDRESS"),
						rs.getString("CF_PHONE"),
						rs.getString("CF_INFO") ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	
	//---------------------------------------------------------------------------------------------
	//카페이름으로 조회
	public List<CafeVO> selectCafeName(String cf_name) {
	      List<CafeVO> list = null;
	      int result = 0;
	      
	      try {
	         //DB 연결 - Connection 객체 생성(DB와 연결된)
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         
	         //SQL문 실행
	         StringBuilder sb = new StringBuilder();
	         sb.append("SELECT CF_ID, CF_NAME, CF_ADDRESS, CF_PHONE, CF_INFO ");
	         sb.append("  FROM CAFE ");
	         sb.append(" WHERE CF_NAME LIKE ? ");
	         sb.append(" ORDER BY CF_ID " );
	         pstmt = conn.prepareStatement(sb.toString());
	         //? 위치에 값 설정
	         pstmt.setString(1, cf_name);
	         
	         rs = pstmt.executeQuery();
	         
	         //SQL문 실행 결과에 대한 처리
	         list = new ArrayList<CafeVO>();
	         while (rs.next()) {
	            list.add(new CafeVO(
	                  rs.getInt("CF_ID"), 
	                  rs.getString("CF_NAME"), 
	                  rs.getString("CF_ADDRESS"), 
	                  rs.getString("CF_PHONE"), 
	                  rs.getString("CF_INFO")
	                  ));
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
	      }
	      
	      return list;
	   }
	
	
	
	//--------------------------------------------------------------------------
	//카페주소로 조회
   public List<CafeVO> selectAddress(String address) {
      List<CafeVO> list = null;
      int result = 0;
      
      try {
         //DB 연결 - Connection 객체 생성(DB와 연결된)
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         
         //SQL문 실행
         StringBuilder sb = new StringBuilder();
         sb.append("SELECT CF_ID, CF_NAME, CF_ADDRESS, CF_PHONE, CF_INFO ");
         sb.append("  FROM CAFE ");
         sb.append(" WHERE CF_ADDRESS LIKE ? ");
         sb.append(" ORDER BY CF_ID " );
         pstmt = conn.prepareStatement(sb.toString());
         //? 위치에 값 설정
         pstmt.setString(1, address);
         
         rs = pstmt.executeQuery();
         
         //SQL문 실행 결과에 대한 처리
         list = new ArrayList<CafeVO>();
         while (rs.next()) {
            list.add(new CafeVO(
                  rs.getInt("CF_ID"), 
                  rs.getString("CF_NAME"), 
                  rs.getString("CF_ADDRESS"), 
                  rs.getString("CF_PHONE"), 
                  rs.getString("CF_INFO")
                  ));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
      }
      
      return list;
   }
	
	
	//-----------------------------------------------------------------------------------
	//카페 정보 넣기
	public int insertCafe(CafeVO cafe) {
		int result = 0;
		
		try {
			//DB 연결 - Connection 객체 생성(DB와 연결된)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL문 실행
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO CAFE ");
			sb.append("       (CF_ID, CF_NAME, CF_ADDRESS, CF_PHONE, CF_INFO) ");
			sb.append("VALUES (CAFE_SEQ.NEXTVAL, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sb.toString());
			
			//? 바인드변수에 값 설정
//			pstmt.setInt(1, cafe.getCf_id());
			pstmt.setString(1, cafe.getCf_name());
			pstmt.setString(2, cafe.getCf_address());
			pstmt.setString(3, cafe.getCf_phone());
			pstmt.setString(4, cafe.getCf_info());
			
			//SQL문 실행(INSERT, UPDATE, DELETE - executeUpdate())
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
		}
		
		return result;
	}
	
			
	//-----------------------------------------------------------------------------------
	//카페정보 수정
		public int updateOne(CafeVO cafe) {
			int result = 0;
			
			try {
				//DB 연결 - Connection 객체 생성(DB와 연결된)
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				//SQL문 실행
				StringBuilder sb = new StringBuilder();
				sb.append("UPDATE CAFE ");
				sb.append("   SET CF_NAME = ?, "); //1
				sb.append("       CF_ADDRESS = ?, ");     //2
				sb.append("       CF_PHONE = ?, ");    //3
				sb.append("       CF_INFO = ? ");   //4
				sb.append(" WHERE CF_ID = ? ");        //5
				pstmt = conn.prepareStatement(sb.toString());
				
				//? 바인드변수에 값 설정
				int i = 1;
				pstmt.setString(i++, cafe.getCf_name());
				pstmt.setString(i++, cafe.getCf_address());
				pstmt.setString(i++, cafe.getCf_phone());
				pstmt.setString(i++, cafe.getCf_info());
				pstmt.setInt(i++, cafe.getCf_id());
				
				//SQL문 실행(INSERT, UPDATE, DELETE - executeUpdate())
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
			}
			
			return result;
		}
			
			
			
		//-----------------------------------------------------------------------------------		
		//카페정보 지우기
		public int deleteCafe(CafeVO cafe) {
			int result = 0;
			
			try {
				//DB 연결 - Connection 객체 생성(DB와 연결된)
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				//SQL문 실행
				String sql = "DELETE FROM CAFE WHERE CF_ID = ? ";
				PreparedStatement pstmt = null;
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, cafe.getCf_id());
				
				result = pstmt.executeUpdate();
				

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
			}

			return result;
		}
		


			
			
			
}

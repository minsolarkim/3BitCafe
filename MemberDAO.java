package com.lastline;
//----------------------------DB연동 및 SQL 클래스-----------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.util.JDBC_Close;
public class MemberDAO {

	    private final String DRIVER = "oracle.jdbc.OracleDriver";
	    private final String URL = "jdbc:oracle:thin:@192.168.0.20:1521:xe";				//SQL 수정부분
	    private final String USER = "PROLAST";
	    private final String PASSWORD = "manager";
	    
	    private Connection conn;
	    private PreparedStatement pstmt;
	    private ResultSet rs;
    	Scanner sc = new Scanner(System.in);

	    
	    public MemberDAO() {
	        try {
	            Class.forName(DRIVER);
//	            System.out.println(">> 드라이버 로딩 성공");
	        } catch (ClassNotFoundException e) {
//	            System.out.println(">> [예외] 드라이버 로딩 실패");
	            e.printStackTrace();
	        }
	        
	    }

	    
	  //--------------------------------------------------------------------
	  //1.회원가입
    public int InsertMember(MemberVO member) {
        int result = 0;
     // DB 연결 - Connection 객체 생성(DB와 연결된)
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            conn.setAutoCommit(false);
            
            StringBuilder sb = new StringBuilder();
            String sql = "INSERT INTO MEMBER (ID, PASSWORD, NAME, PHONE, ADDRESS) "				//SQL 수정부분
            		+ " VALUES (?, ?, ?, ?, ?)  ";												//SQL 수정부분
            pstmt = conn.prepareStatement(sql);
            //?바인드변수에 값 설정
            int i = 1;
            pstmt.setString(i++, member.getId());
            pstmt.setString(i++, member.getPassword());
            pstmt.setString(i++, member.getName());
            pstmt.setString(i++, member.getPhone());
            pstmt.setString(i++, member.getAddress());
            
            //SQL문 실행
            result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);

		}
        
        return result;
    }
    
    
    //--------------------------------------------------------------------
    //2.로그인
    public int loginTest(String id, String password) {
//    	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	boolean flag = false;
        String sql = "";
 
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 문장생성
            sql = "SELECT PASSWORD FROM MEMBER WHERE ID=?";				//SQL 수정부분
 
            // 문장연결
            pstmt = conn.prepareStatement(sql);
            // 빈칸채워주기
            pstmt.setString(1, id);
            //실행
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
//                	rs.beforeFirst();
				if (rs.getString(1).equals(password)) 
					return 1; // 로그인 성공
				else 
					return 0; // 비밀번호 불일치
			}
			return -1; // 아이디가 없음
    			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
		}
		return -2; // DB 오류 
	}
    
    //-------------------------------------------------------------------->
    //3.회원수정(UPDATE) - 비밀번호 변경
    public int updatePasswordInfo(String id, String password) {
        int cnt = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
           //DB연결
          conn = DriverManager.getConnection(URL, USER, PASSWORD);
          
          //SQL문
          StringBuilder sql = new StringBuilder();
          sql.append("UPDATE MEMBER SET PASSWORD = ? WHERE ID = ? ");
          
          //?바인드변수에 값 설정
          pstmt = conn.prepareStatement(sql.toString());
          pstmt.setString(1, password);
          pstmt.setString(2, id);
          //실행
          cnt = pstmt.executeUpdate();
          
          
          if(cnt > 0) {
              System.out.println("\n>>>>>회원수정이 정상적으로 완료되었습니다.\n");
          }else {
             System.out.println("\n 회원수정 실패!");
          }
          
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
       }
       return cnt;
     }
    
    //-------------------------------------------------------------------->
    //3.회원수정(UPDATE) - 전화번호 변경
    public int updatePhoneInfo(String id, String phone) {
        int cnt = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
           //DB연결
          conn = DriverManager.getConnection(URL, USER, PASSWORD);
          
          //SQL문
          StringBuilder sql = new StringBuilder();
          sql.append("UPDATE MEMBER SET PHONE= ? WHERE ID = ? ");
          
          //?바인드변수에 값 설정
          pstmt = conn.prepareStatement(sql.toString());
          pstmt.setString(1, phone);
          pstmt.setString(2, id);
          //실행
          cnt = pstmt.executeUpdate();
          
          
          if(cnt > 0) {
              System.out.println("\n>>>>>회원수정이 정상적으로 완료되었습니다.\n");
          }else {
             System.out.println("\n 회원수정 실패!");
          }
          
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
       }
       return cnt;
     }
    
    //-------------------------------------------------------------------->
    //3.회원수정(UPDATE) - 주소 변경
    public int updateAddressInfo(String id, String address) {
        int cnt = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
           //DB연결
          conn = DriverManager.getConnection(URL, USER, PASSWORD);
          
          //SQL문
          StringBuilder sql = new StringBuilder();
          sql.append("UPDATE MEMBER SET ADDRESS = ? WHERE ID = ? ");
          
          //?바인드변수에 값 설정
          pstmt = conn.prepareStatement(sql.toString());
          pstmt.setString(1, address);
          pstmt.setString(2, id);
          //실행
          cnt = pstmt.executeUpdate();
          
          
          if(cnt > 0) {
              System.out.println("\n>>>>>회원수정이 정상적으로 완료되었습니다.\n");
          }else {
             System.out.println("\n 회원수정 실패!");
          }
          
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
       }
       return cnt;
     }
    
    //--------------------------------------------------------------------
    //3.회원탈퇴(DELETE)
	public int deleteMember(MemberVO member) {
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "DELETE FROM MEMBER WHERE ID = ? AND PASSWORD = ? ";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, member.getId());
	        pstmt.setString(2, member.getPassword());
	
	        result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
	
		}
		return result;
	}
    
    

    
    
}

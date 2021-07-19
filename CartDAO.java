package com.lastline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.util.JDBC_Close;

public class CartDAO {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.20:1521:xe";				//SQL 수정부분
    private final String USER = "PROLAST";
    private final String PASSWORD = "manager";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
	Scanner sc = new Scanner(System.in);

    
    public CartDAO() {
        try {
            Class.forName(DRIVER);
//            System.out.println(">> 드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
//            System.out.println(">> [예외] 드라이버 로딩 실패");
            e.printStackTrace();
        }
        
    }

    //--------------------------------------------------------------------
    //1.장바구니 삭제(DELETE)
    public int deleteCart(CartVO cart) {
        int result = 0;
        
        try {
           //DB 연결 - Connection 객체 생성(DB와 연결된)
           conn = DriverManager.getConnection(URL, USER, PASSWORD);
           //SQL문 실행
           String sql = "DELETE FROM CART WHERE C_ID = ? ";
           
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, cart.getC_id());
           
           result = pstmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
        }
        return result;
     }
    
    
    //--------------------------------------------------------------------
    //2.장바구니 담기(insert)
    public int insertCart(String id, int pro_id) {
    	
    	 int result = 0;
         // DB 연결 - Connection 객체 생성(DB와 연결된)
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                
             // SQL문 실행
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO CART ");
                sb.append("       (C_ID, ID, PRO_ID,LIST, PRICE) ");
                sb.append("VALUES ( CART_SEQ.NEXTVAL, ?, ?, (SELECT PRO_NAME FROM PRODUCT WHERE PRO_ID = ?), ");
                sb.append("(SELECT PRO_PRICE FROM PRODUCT WHERE PRO_ID = ?)) ");
                pstmt = conn.prepareStatement(sb.toString());
                
                //?바인드변수에 값 설정
                pstmt.setString(1, id);
                pstmt.setInt(2, pro_id);
                pstmt.setInt(3, pro_id);
                pstmt.setInt(4, pro_id);
                
                //SQL문 실행
                result = pstmt.executeUpdate();
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
            }
            
            return result; 
    	

    }
    
    //--------------------------------------------------------------------
    //3.장바구니 출력(select)
	public List<CartVO> selectCartList(String id){
		List<CartVO> list = null;
        int result = 0;
        MemberMenuPrint pr = new MemberMenuPrint();

		try {
			//DB 연결 - Connection 객체 생성(DB와 연결된)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL문 실행
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT C_ID, ID, PRO_ID, PRICE, LIST ");
			sb.append("  FROM CART ");
			sb.append("WHERE ID = ? " );
			sb.append(" ORDER BY C_ID ");
			pstmt = conn.prepareStatement(sb.toString());
			
            pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			//SQL문 실행 결과에 대한 처리
			list = new ArrayList<CartVO>();
			while (rs.next()) {
				CartVO cvo = new CartVO(						
						rs.getInt("C_ID"),
						rs.getString("ID"),
						rs.getInt("PRO_ID"),
						rs.getInt("PRICE"),
						rs.getString("LIST"));
						list.add(cvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
		}
		
		return list;
	}
	
    //--------------------------------------------------------------------
    //4.결제정보 출력(select)
	public int CartListSum(String id){
        int result = 0;
        MemberMenuPrint pr = new MemberMenuPrint();

		try {
			//DB 연결 - Connection 객체 생성(DB와 연결된)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL문 실행
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT SUM(PRICE) ");
			sb.append("  FROM CART ");
			sb.append("WHERE ID = ? ");
//			sb.append("GROUP BY ID " );
//			sb.append("HAVING ID = ? ");
			pstmt = conn.prepareStatement(sb.toString());
			
            pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			//SQL문 실행 결과에 대한 처리
			if (rs.next()) {
				result = rs.getInt(1);
			}			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
		}
		
		return result;
	}
	
    //--------------------------------------------------------------------
    //5.결제완료후 테이블 비우기 
    public int deleteCart2(String id) {
        int result = 0;
        
        try {
           //DB 연결 - Connection 객체 생성(DB와 연결된)
           conn = DriverManager.getConnection(URL, USER, PASSWORD);
           //SQL문 실행
           String sql = "DELETE FROM CART WHERE ID = ? ";
           
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, id);
           
           result = pstmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           JDBC_Close.CloseConnStmtRs(conn, pstmt, rs);
        }
        return result;
     }
}

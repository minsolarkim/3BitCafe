package com.lastline;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//----------------------------화면을 출력하는 클래스-----------------------------
import java.util.Scanner;


public class MemberMenuPrint {
//	private Connection conn;
//    private PreparedStatement pstmt;
//    private ResultSet rs;

	MemberDAO dao;
	CartDAO dao2;
	static String id_idx;

	//기본생성자
    public MemberMenuPrint() {
        dao = new MemberDAO(); 
        dao2 = new CartDAO();
    }
  
    //--------------------------------------------------------------------
    //1.회원가입
    public void insertMember(){        
       
        Scanner sc = new Scanner(System.in);
       
        System.out.println("회원정보를 입력해주세요.");
        System.out.print("▶ID : ");
        String id = sc.nextLine();
        System.out.print("▶비밀번호 : ");
        String password = sc.nextLine();
        System.out.print("▶이름 : ");
        String name = sc.nextLine();
        System.out.print("▶연락처 : ");
        String phone = sc.nextLine();   
        System.out.print("▶주소 : ");
        String address = sc.nextLine();
       
        MemberVO vo = new MemberVO(id, password, name, phone, address);
        dao.InsertMember(vo); //입력받은 데이터 추가
        System.out.println("\n>>>>>회원등록이 정상적으로 완료되었습니다.\n");

    }  
    
    //--------------------------------------------------------------------
    //2.로그인
        public void LoginMember() {
        	ProjectRun2 run2 = new ProjectRun2();
        	Scanner sc = new Scanner(System.in);
        	MemberDAO dao = new MemberDAO();
        	
            System.out.print("▶ID : ");
            String id = sc.nextLine();
            System.out.print("▶비밀번호 : ");
            String password = sc.nextLine();
        	
            int result = dao.loginTest(id, password);
            if(result == 1){
            	System.out.println(">>>>>로그인 성공!!");
            	id_idx = id;
            	run2.menu();
            }

            else if(result == 0) {
            	System.out.println("비밀번호 불일치");
            }
            else if( result == -1) {
            	System.out.println("아이디가 없음");
            }
            else if(result == -2){
            	System.out.println(">>>>>데이터베이스 오류가 발생했습니다. 잠시 후에 다시 시도해주세요.");
            }
        }
        
        //--------------------------------------------------------------------
        //3.회원수정 (비밀번호 수정)
        public void updatePassword() {
            
            ProjectRun run = new ProjectRun();
            Scanner sc = new Scanner(System.in);
            MemberDAO dao = new MemberDAO();
            
          System.out.println("회원아이디를 입력하시오");
          System.out.print("▶ ID : ");
          String id = sc.nextLine();

		   System.out.println("\n수정 할 회원 비밀번호를 입력하시오 ");
		   System.out.print("▶ 비밀번호 : ");
		   String password = sc.nextLine();
		   int result = dao.updatePasswordInfo(id, password);
         }
        
        //--------------------------------------------------------------------
        //3.회원수정 (전화번호 수정)
        public void updatePhone() {
            
            ProjectRun run = new ProjectRun();
            Scanner sc = new Scanner(System.in);
            MemberDAO dao = new MemberDAO();
            
          System.out.println("회원아이디를 입력하시오");
          System.out.print("▶ ID : ");
          String id = sc.nextLine();

		   System.out.println("\n수정 할 회원 전화번호를 입력하시오 ");
		   System.out.print("▶ 전화번호 : ");
		   String phone = sc.nextLine();
		   int result = dao.updatePhoneInfo(id, phone);
         }
        
        //--------------------------------------------------------------------
        //3.회원수정 (주소 수정)
        public void updateAddress() {
            
            ProjectRun run = new ProjectRun();
            Scanner sc = new Scanner(System.in);
            MemberDAO dao = new MemberDAO();
            
          System.out.println("회원아이디를 입력하시오");
          System.out.print("▶ ID : ");
          String id = sc.nextLine();

		   System.out.println("\n수정 할 회원 주소를 입력하시오 ");
		   System.out.print("▶ 주소 : ");
		   String address = sc.nextLine();
		   int result = dao.updatePasswordInfo(id, address);
         }
        
        
        //--------------------------------------------------------------------
        //4.회원탈퇴
        public void deleteMemberPrint() {
        	Scanner sc = new Scanner(System.in);
        	
        	System.out.println("===회원탈퇴===");
        	System.out.print("회원 ID : ");
        	String id = sc.nextLine();
        	System.out.print("회원 PASSWORD : ");
        	String password = sc.nextLine();
        	
        	MemberVO memberVO = new MemberVO(id,password,"","","");
        	int cnt = dao.deleteMember(memberVO);
        	
        	dao.deleteMember(memberVO);
        	System.out.println("수정건수 : " + cnt);
            if(cnt == 0) {
            System.out.println("\n>>>>>삭제에 실패했습니다\n");
            }
            else {
            System.out.println("\n>>>>>삭제 완료되었습니다.\n");
            }
        }
    
        
   
    // 공백입력시 재입력, 테스트 메소드
    public String reInput(Scanner scn){
       
        String str="";
        while(true){
            str = scn.nextLine();
            if(!(str==null || str.trim().equals(""))){
                break;
            }else{
                System.out.println("공백은 입력하실수없습니다. 올바른값을 입력해주세요!");
                System.out.print("▶");
            }
        }
       
        return str;
    }
}
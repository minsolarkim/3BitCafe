package com.lastline;
//----------------------------구동하는 main 클래스-----------------------------
import java.util.Scanner;

public class ProjectRun {

	// 메뉴
		public static void menu() {
			System.out.println();
			System.out.println("-----------------<**커피 & 디저트 쇼핑 프로그램**>-----------------");
			System.out.println("========================= >> 메뉴 << ========================");
			System.out.println("=== 1.회원가입  |  2.로그인  |  3.회원수정  |  4.회원탈퇴 |  5.종료 ===");
			System.out.println("============================================================");
			System.out.print(" ▷ 메뉴번호 선택 : ");
		} // end of static void menu() --------------------
		
		public static void main(String[] args) {
			MemberDAO dao = new MemberDAO();
			MemberMenuPrint pr = new MemberMenuPrint();
			// 스캐너
			Scanner sc = new Scanner(System.in);
			String strMenuNo = "";
			do {
				ProjectRun.menu();
				strMenuNo = sc.nextLine();
				
				switch (strMenuNo) {
				case "1":				// 회원가입
					pr.insertMember();
					break;
				case "2":				// 로그인
					pr.LoginMember();
					break;
				case "3":				// 회원정보 수정
					updateMenu();
					break;
				case "4":				// 회원 탈퇴
					pr.deleteMemberPrint();
					break;
				case "5":				//프로그램 종료
					System.out.println("\n>>> 프로그램을 종료합니다. 이용해 주셔서 감사합니다! <<<");
					System.exit(0);
					break;

				default:
					System.out.println(">> 메뉴에 없는 번호를 선택하셨습니다. \n");
					break;
				}
				
			} while (!"5".equals(strMenuNo));
			
			sc.close();
		}

		private static void updateMenu() {
			MemberMenuPrint pr = new MemberMenuPrint();
			Scanner sc = new Scanner(System.in);
	        System.out.println("== 1.비밀번호 변경  |  2.연락처 수정  |  3.주소 수정 ==");
	        System.out.print("▶ ");
	        int a = sc.nextInt();
	        if(a == 1) {
	        	pr.updatePassword();
	        } else if( a ==2 ) {
	        	pr.updatePhone();
	        } else if ( a==3 ) {
	        	pr.updateAddress();
	        } else {
	        	System.out.println("잘못입력하셨습니다.");
	        }			
		}
}

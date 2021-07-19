package com.lastline;
import java.util.List;
//----------------------------구동하는 main 클래스-----------------------------
import java.util.Scanner;
import static com.lastline.MemberMenuPrint.id_idx;

public class ProjectRun2 {
	static Scanner sc = new Scanner(System.in);
	static String strMenuNo = "";
	
//	static MemberDAO dao = new MemberDAO();
//	static CafeDAO dao2 = new CafeDAO();
	static CartDAO dao3 = new CartDAO();
	
	
	static MemberMenuPrint pr = new MemberMenuPrint();
	static CafeMenuPrint pr2 = new CafeMenuPrint();
	static CartMenuPrint pr3 = new CartMenuPrint();
	static ProductMenuPrint pr4 = new ProductMenuPrint();

	// 메인메뉴
		public static void menu() {
			do {
				System.out.println();
				System.out.println("                                             *"+pr.id_idx+"님 로그인중*");
				System.out.println("========================<**검색 선택**>========================");
				System.out.println("== 1.커피 및 디저트 검색  |  2.카페 검색  |  3.장바구니  |  4.로그아웃 ==");
				System.out.println("============================================================");
				System.out.print(" ▷ 메뉴번호 선택 : ");
				strMenuNo = sc.nextLine();
				
				switch (strMenuNo) {
				case "1":	//커피 디저트 검색	
					System.out.println(); 
					productPrint();
					break;
				case "2":	//카페 검색
					System.out.println(); 
					cafePrint();
					break;
				case "3":	//장바구니
					System.out.println();
					cartPrint();
					break;
				case "4":	// 프로그램 종료 / 첫 페이지로 이동
					ProjectRun projectRun = new ProjectRun();
					projectRun.main(null);
					break;

				default:
					System.out.println(">> 메뉴에 없는 번호를 선택하셨습니다. \n");
					break;
				}
			} while (!"4".equals(strMenuNo));
			
			sc.close();
		} 

	
	//-----------------------------------------------------------------------
	//메인 메뉴 - case 3: 장바구니	
	public static void cartPrint() {
		do {
			System.out.println();
			System.out.println("                                 *"+pr.id_idx+"님 로그인중*");			
			System.out.println("=====================<**장바구니**>=====================");
			System.out.println("== 1.목록 보기  |  2.목록 삭제  |  3.결제하기  |  4.뒤로가기 ==");
			System.out.println("=====================================================");
			System.out.print(" ▷ 메뉴번호 선택 : ");
			strMenuNo = sc.nextLine();
			
			switch (strMenuNo) {
			case "1":	//장바구니 목록 보기
				pr3.viewCartList();
				break;
			case "2":	//장바구니 삭제
				System.out.println();
				pr3.deleteCartPrint();
				break;
			case "3":	// 뒤로가기
				pr3.viewCartListSum();
				break;
			case "4":	// 뒤로가기
				menu();
				break;
			default:
				System.out.println(">> 메뉴에 없는 번호를 선택하셨습니다. \n");
				break;
			}
			
		} while (!"3".equals(strMenuNo));		
	}


	//-----------------------------------------------------------------------
	//메인 메뉴 - case 2: 카페 검색	
	private static void cafePrint() {
		do {
			System.out.println();
			System.out.println("                                                                        *"+pr.id_idx+"님 로그인중*");			
			System.out.println("=========================================<**카페 커뮤니티**>==========================================");
			System.out.println("== 1.카페이름으로 검색  |  2.주소로 검색  |  3.카페정보 전체보기  |  4.카페정보 입력  |  5.카페정보 삭제 |  6.뒤로가기 ==");
			System.out.println("==================================================================================================");
			System.out.print(" ▷ 메뉴번호 선택 : ");
			strMenuNo = sc.nextLine();
			
			switch (strMenuNo) {
			case "1":	//카페이름으로 검색
				pr2.selectCafeName();
				break;
			case "2":	//지역으로 검색
				pr2.selectCafeAddress();
				break;
			case "3":	// 카페정보 전체보기
				pr2.selectCafe();
				break;
			case "4":	// 카페정보 입력
				pr2.insertCafe();
				break;
			case "5":	// 카페정보 수정
				pr2.deleteCafe();
				break;
			case "6":	// 뒤로가기
				menu();
				break;
			default:
				System.out.println(">> 메뉴에 없는 번호를 선택하셨습니다. \n");
				break;
			}
			
		} while (!"3".equals(strMenuNo));		
	}

	
	//-----------------------------------------------------------------------
	//메인 메뉴 - case 1: 커피 및 디저트로 검색	
	private static void productPrint() {
		do {
			System.out.println();
			System.out.println("                                        *"+pr.id_idx+"님 로그인중*");			
			System.out.println("===================<**커피&디저트 검색**>===================");
			System.out.println("1.이름으로 검색  |  2.원두종류별 검색  |  3.타입별 검색  |  4.뒤로가기");
			System.out.println("=======================================================");
			System.out.print(" ▷ 메뉴번호 선택 : ");
			strMenuNo = sc.nextLine();
			
			switch (strMenuNo) {
			case "1":	
				pr4.selectProductNamePrint();
				break;
			case "2":	
				pr4.selectBeansPrint();
				break;
			case "3":	
				pr4.selectTypePrint();
				break;
			case "4":	
				menu();
				break;

			default:
				System.out.println(">> 메뉴에 없는 번호를 선택하셨습니다. \n");
				break;
			}
			
		} while (!"4".equals(strMenuNo));
		
	}
		
}












package com.lastline;

import java.util.List;
import java.util.Scanner;


public class CartMenuPrint {
	CartDAO dao = new CartDAO();
//	CartDAO dao;
	static Scanner sc = new Scanner(System.in);
	static MemberMenuPrint pr = new MemberMenuPrint();
	static CartMenuPrint pr3 = new CartMenuPrint();
	static ProjectRun2 run2 = new ProjectRun2();
	//기본생성자
    public CartMenuPrint() {
        dao = new CartDAO();

    }
    //--------------------------------------------------------------------
    //1.장바구니 삽입
    public void insertCartPrint() {
        System.out.println("선택한 제품의 번호를 입력하세요.\n");
        System.out.print("▶ 번호 : ");
        int pro_id = sc.nextInt();
        
//    	CafeVO cafeVO;
        CartVO vo = new CartVO(0, pr.id_idx, pro_id, 0, "");
        dao.insertCart(pr.id_idx, pro_id);
        
        System.out.println(">>장바구니에 담았습니다!");
        run2.cartPrint();
    }
    
    
    //--------------------------------------------------------------------
    //2.장바구니 삭제
    public void deleteCartPrint(){        
       
        System.out.println("삭제할 목록의 번호를 입력하세요.\n");
        System.out.print("▶목록번호 : ");
        int c_id = sc.nextInt();

       
        CartVO cartVO = new CartVO(c_id, "", 0, 0, "");
        int cnt = dao.deleteCart(cartVO);

        dao.deleteCart(cartVO); //입력받은 데이터 추가
        System.out.println("수정건수 : " + cnt);
        if(cnt == 0) {
        System.out.println("\n>>>>>삭제에 실패했습니다\n");
        }
        else {
        System.out.println("\n>>>>>삭제 완료되었습니다.\n");
        }

    } 
    
	//----------------------------------------------------------------------
	//3.장바구니 목록보기 
    public void viewCartList() {
    	List<CartVO> list = dao.selectCartList(pr.id_idx);
    			
	      for (CartVO cvo : list) {
	         System.out.println(cvo);
	      }
	      
    }
  
	//----------------------------------------------------------------------
	//4.결제 목록보기 
    public void viewCartListSum() {
    	int sumPrice = dao.CartListSum(pr.id_idx);
    	System.out.println("\n▷▷"+ pr.id_idx + "님의 총 결제금액◁◁");
    	System.out.println("▶ 금액 : " + sumPrice);
    	System.out.println("구매하시겠습니까?    YES:1  |  NO:2");
    	System.out.print("▶ 입력 : ");
    	int num = sc.nextInt();
    	if(num == 1) {
    		System.out.println("□□□□□□□□□□□ 구매완료! □□□□□□□□□□□");
    		dao.deleteCart2(pr.id_idx);
    		run2.menu();
    	} else if (num == 2) {
    		 System.out.println("구매를 취소하셨습니다.");
    		 run2.cartPrint();
    	} else {
    		System.out.println("잘못입력하셨습니다.");
    	}
    	
    	
    }
    
	//----------------------------------------------------------------------
	//insert에 print부분
	public static void insertCartGo() { 
		 {
			
		      System.out.println("\n장바구니에 담으시겠습니까?    YES:1  |  NO:2");
		      System.out.print("▶ 입력 : ");
		      
		      int num = sc.nextInt();
		      
		      if(num == 1) {
		    	  pr3.insertCartPrint();
		      } else if (num == 2) {
		    	  run2.cartPrint();
		      }
		}
	}
    
    
}

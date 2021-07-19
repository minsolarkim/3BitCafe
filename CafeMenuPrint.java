package com.lastline;

import java.util.List;
import java.util.Scanner;

public class CafeMenuPrint {
	CafeDAO dao;
	static Scanner sc = new Scanner(System.in);
	//기본생성자
    public CafeMenuPrint() {
        dao = new CafeDAO();
    }
    
    //--------------------------------------------------------------------
    //1.카페 이름으로 검색
    public void selectCafeName() {
		System.out.print("\n▶ 카페 이름 : ");
		String cafeName = sc.nextLine();		
		System.out.println();
		
	    List<CafeVO> list = dao.selectCafeName("%" + cafeName + "%");
	    for(CafeVO cafeA : list) {
	       System.out.println(cafeA);
	    }		

    }
    
    
    //--------------------------------------------------------------------
    //2.카페 주소로 검색
    public void selectCafeAddress() {
		System.out.print("\n▶ 카페 주소 : ");
		 String userAddress = sc.nextLine();
	      List<CafeVO> list = dao.selectAddress("%" + userAddress + "%");
	      for(CafeVO cafeA : list) {
	         System.out.println(cafeA);
	      }
    }
    
    //--------------------------------------------------------------------
    //3.카페 전체출력
    public void selectCafe() {
    	List<CafeVO> list = dao.selectAll();
		for (CafeVO cvo : list) {
			System.out.println(cvo);
		}
    }
    
    //--------------------------------------------------------------------
    //4.카페정보 입력
    public void insertCafe() {
       System.out.print("\n▶ 카페 이름 : ");
       String cafeName = sc.nextLine();
       System.out.print("\n▶ 카페 주소 : ");
       String cafeAddress = sc.nextLine();
       System.out.print("\n▶ 카페 번호 : ");
       String cafePhone = sc.nextLine();
       System.out.print("\n▶ 카페 정보 : ");
       String cafeInfo = sc.nextLine();
       
       CafeVO vo = new CafeVO(0, cafeName, cafeAddress, cafePhone, cafeInfo);
       dao.insertCafe(vo);
       System.out.println("\n>>>>>카페정보 등록이 정상적으로 완료되었습니다.\n");
    }
    
    
    //--------------------------------------------------------------------
    //5.카페정보 삭제 
    
    public void deleteCafe() {
    	Scanner sc = new Scanner(System.in);
    	
    	 List<CafeVO> list = dao.selectAll();
	      for(CafeVO cafeA : list) {
	         System.out.println(cafeA);
	      }
    	
    	System.out.println("===카페 삭제===");
    	System.out.print("삭제할 카페 번호 : ");
    	int cf_id = sc.nextInt();
    	
    	CafeVO cafeVO = new CafeVO(cf_id, "", "", "", "");
    	int cnt = dao.deleteCafe(cafeVO);
    	
    	dao.deleteCafe(cafeVO);
    	System.out.println("수정건수 : " + cnt);
        if(cnt == 0) {
        System.out.println("\n>>>>>삭제에 실패했습니다\n");
        }
        else {
        System.out.println("\n>>>>>삭제 완료되었습니다.\n");
        }
    }
    
    
    
     
}

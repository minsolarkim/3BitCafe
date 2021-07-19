package com.lastline;

import java.util.List;
import java.util.Scanner;

public class ProductMenuPrint {
	ProductDAO dao;
	static Scanner sc = new Scanner(System.in);
	static CartMenuPrint pr3 = new CartMenuPrint();

	//기본생성자
    public ProductMenuPrint() {
        dao = new ProductDAO();
    }
    
    //--------------------------------------------------------------------
    //1.상품 이름으로 검색
    public void selectProductNamePrint() {
        System.out.println("커피 & 디저트 이름을 입력하세요.\n");
        System.out.print("▶ 검색 : ");
        String userProName = sc.nextLine();
        
        
		List<ProductVO> list = dao.selectProductName("%" + userProName + "%");
	      for (ProductVO cvo : list) {
	         System.out.println(cvo);
	      }
	      
	      if(list.size() != 0) {
	    	  pr3.insertCartGo();
	      } else {
	    	  System.out.println("목록이 없습니다.");
	      }
    }
    
    
    //--------------------------------------------------------------------
    //2.원두별 검색
    public void selectBeansPrint(){        
        
        System.out.println("원두 이름을 입력하세요.\n");
        System.out.print("▶ 검색 : ");
        String beans = sc.nextLine();
       
        ProductVO productVO;
        ProductVO vo = new ProductVO(0, "", "", 0 , "", beans, "");
        
		List<ProductVO> list = dao.selectProductBeans(beans);
	      for (ProductVO cvo : list) {
	         System.out.println(cvo);
	      }
	      
	      if(list.size() != 0) {
	    	  pr3.insertCartGo();
	      } else {
	    	  System.out.println("목록이 없습니다.");
	      }
    } 
    
    
    //--------------------------------------------------------------------
    //3.타입별 검색 (커피, 디저트)
    public void selectTypePrint(){        
        
        System.out.println("커피/디저트 중 입력하세요.\n");
        System.out.print("▶ 검색 : ");
        String type = sc.nextLine();
        
        ProductVO productVO;
        ProductVO vo = new ProductVO(0, "", type, 0 , "", "", "");
        
        
        List<ProductVO> list = dao.selectProductType(type);
	      for (ProductVO cvo : list) {
	         System.out.println(cvo);
	      }
	      
	      if(list.size() != 0) {
	    	  pr3.insertCartGo();
	      } else {
	    	  System.out.println("목록이 없습니다.");
	      }
     } 



}

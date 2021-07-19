package com.lastline;

public class ProductVO {
   
   //필드 : 컬럼명, 타입 동일하게 설정
   private int pro_id;
   private String pro_name;
   private String type;
   private int pro_price;
   private String cafe_name;
   private String beans;
   private String pro_info;
   
   public ProductVO(Integer pro_id, String pro_name, String type, Integer pro_price, String cafe_name, String beans,
         String pro_info) {
      super();
      this.pro_id = pro_id;
      this.pro_name = pro_name;
      this.type = type;
      this.pro_price = pro_price;
      this.cafe_name = cafe_name;
      this.beans = beans;
      this.pro_info = pro_info;
   }
   
   @Override
   public String toString() {
      return "상품ID:" + pro_id + " | 상품이름:" + pro_name + " | 분류(타입):" + type + " | 가격:" + pro_price
            + " |  카페이름:" + cafe_name + " | 원두종류:" + beans + " | 정보:" + pro_info + "]";
   }

   public Integer getPro_id() {
      return pro_id;
   }

   public void setPro_id(Integer pro_id) {
      this.pro_id = pro_id;
   }

   public String getPro_name() {
      return pro_name;
   }

   public void setPro_name(String pro_name) {
      this.pro_name = pro_name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public Integer getPro_price() {
      return pro_price;
   }

   public void setPro_price(Integer pro_price) {
      this.pro_price = pro_price;
   }

   public String getCafe_name() {
      return cafe_name;
   }

   public void setCafe_name(String cafe_name) {
      this.cafe_name = cafe_name;
   }

   public String getBeans() {
      return beans;
   }

   public void setBeans(String beans) {
      this.beans = beans;
   }

   public String getPro_info() {
      return pro_info;
   }

   public void setPro_info(String pro_info) {
      this.pro_info = pro_info;
   }
   
   

}
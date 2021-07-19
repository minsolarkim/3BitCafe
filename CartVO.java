package com.lastline;

public class CartVO {
    private int c_id;
    private String id;
    private int pro_id;
    private int price;
    private String list;

	public CartVO(int c_id, String id, int pro_id, int price, String list) {
		super();
		this.c_id = c_id;
		this.id = id;
		this.pro_id = pro_id;
		this.price = price;
		this.list = list;
	}
	

	public CartVO(int pro_id) {
		super();
		this.pro_id = pro_id;
	}
	
	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getPro_id() {
		return pro_id;
	}


	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getList() {
		return list;
	}


	public void setList(String list) {
		this.list = list;
	}
	    
	@Override
    public String toString() {
        return ">>목록번호:"+ c_id +" | 회원ID:" + id + " | 품목:" + list + " | 가격" + price + "]";
    }
}

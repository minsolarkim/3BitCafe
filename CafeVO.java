package com.lastline;

public class CafeVO {
	private int cf_id;
	private String cf_name;
	private String cf_address;
	private String cf_phone;
	private String cf_info;
	
	public CafeVO(int cf_id, String cf_name, String cf_address, String cf_phone, String cf_info) {
		super();
		this.cf_id = cf_id;
		this.cf_name = cf_name;
		this.cf_address = cf_address;
		this.cf_phone = cf_phone;
		this.cf_info = cf_info;
	}

	public int getCf_id() {
		return cf_id;
	}

	public void setCf_id(int cf_id) {
		this.cf_id = cf_id;
	}

	public String getCf_name() {
		return cf_name;
	}

	public void setCf_name(String cf_name) {
		this.cf_name = cf_name;
	}

	public String getCf_address() {
		return cf_address;
	}

	public void setCf_address(String cf_address) {
		this.cf_address = cf_address;
	}

	public String getCf_phone() {
		return cf_phone;
	}

	public void setCf_phone(String cf_phone) {
		this.cf_phone = cf_phone;
	}

	public String getCf_info() {
		return cf_info;
	}

	public void setCf_info(String cf_info) {
		this.cf_info = cf_info;
	}

	@Override
	public String toString() {
		return ">> [카페번호:" + cf_id + " | 카페이름:" + cf_name + " | 카페주소:" + cf_address + " | 전화번호="
				+ cf_phone + " | 카페정보:" + cf_info + "]";
	}
	
	
}

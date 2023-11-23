package model.item;
/*
 * 데이터베이스 저장된 값을 토대로 값을 저장하기 위한 객체
 * DTO (Data Transfer Object), VO (Value Object), Entity  
 * 깃 부활
 */
public class Item {
	private int code;
	private String name;
	private int price;

	private double minRate;
	private double maxRate;
	
	
	public Item() {
		super();
	}

	public Item(int code, String name, int price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public Item(int code, String name, int price, double minRate, double maxRate) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.minRate = minRate;
		this.maxRate = maxRate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	public double getMinRate() {
		return minRate;
	}

	public void setMinRate(double minRate) {
		this.minRate = minRate;
	}

	public double getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(double maxRate) {
		this.maxRate = maxRate;
	}


}

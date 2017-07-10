package won.reservation.domain;

import java.sql.Timestamp;

public class ProductPrice {
	private int id;
	private int productId;
	private int priceType;
	private int price;
	private Double discountRate; //DECIMAL
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public ProductPrice() {
		
	}

	public ProductPrice(int id, int productId, int priceType, int price, Double discountRate, Timestamp createDate, Timestamp modifyDate) {
		this.id = id;
		this.productId = productId;
		this.priceType = priceType;
		this.price = price;
		this.discountRate = discountRate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "[ProductPrice] id = " + id +", productId = " + productId +", priceType = " + priceType +", price = "+price
				+", discountRate = " + discountRate + ", createDate = " + createDate +", modifyDate = "+ modifyDate;
	}
}

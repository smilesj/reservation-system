package won.reservation.domain;

import java.sql.Timestamp;

public class Product {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	private Timestamp salesStart;
	private Timestamp salesEnd;
	private int salesFlag;
	private String event;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public Product() {
		
	}

	public Product(int id, int categoryId, String name, String description, Timestamp salesStart, Timestamp salesEnd,
			int salesFlag, String event, Timestamp createDate, Timestamp modifyDate) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.salesStart = salesStart;
		this.salesEnd = salesEnd;
		this.salesFlag = salesFlag;
		this.event = event;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getSalesStart() {
		return salesStart;
	}

	public void setSalesStart(Timestamp salesStart) {
		this.salesStart = salesStart;
	}

	public Timestamp getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(Timestamp salesEnd) {
		this.salesEnd = salesEnd;
	}

	public int getSalesFlag() {
		return salesFlag;
	}

	public void setSalesFlag(int salesFlag) {
		this.salesFlag = salesFlag;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
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
		return "[PRODUCT] id = " + id +  ", categoryId = "+categoryId +", name = " + name +", description = " + description
				+ ", salesStart = " + salesStart + ", salesEnd = "+ salesEnd+ ", salesFlag = "+ salesFlag+ ", event = "+ event
				+ ", createDate = " + createDate + ", modifyDate = "+ modifyDate;
	}
}

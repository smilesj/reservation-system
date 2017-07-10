package won.reservation.domain;

public class ProductImage {
	private int id;
	private int productId;
	private int fileId;
	private int type;
	
	public ProductImage() {
		
	}

	public ProductImage(int id, int productId, int fileId, int type) {
		super();
		this.id = id;
		this.productId = productId;
		this.fileId = fileId;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "[ProductImage] id = " + id +", productId = " + productId +", fileId = " + fileId +", type = " + type;
	}
}

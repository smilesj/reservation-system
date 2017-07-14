package won.reservation.dto;

// 메인페이지에서 보이는 상품 정보를 담는 DTO
public class ProductInfo {
	private int productId;
	private String productName;
	private String fileName;
	private String saveFileName;
	private String placeName;
	private String description;
	
	public ProductInfo() {
	}
	
	public ProductInfo(int productId, String productName, String fileName, String saveFileName, String placeName, String description) {
		this.productId = productId;
		this.productName = productName;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.placeName = placeName;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

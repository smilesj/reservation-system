package won.reservation.service;

import java.util.List;
import java.util.Map;

import won.reservation.domain.Product;
import won.reservation.domain.ProductDetail;
import won.reservation.dto.ProductDetailInfo;

public interface ProductService {
	public List<Product> readProduct();
	public ProductDetailInfo readProduct(Integer productId);
	public int addProduct(Product product);
	public int update(Product product);
	public int delete(int id);
	public int getCount(Integer categoryId);
	public Map<String, Object> readProductInfo(Integer start);
	public Map<String, Object> readProductInfoCategory(Integer categoryId, Integer start);
}

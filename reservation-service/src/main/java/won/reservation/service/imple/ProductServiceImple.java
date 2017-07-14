package won.reservation.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.FileDao;
import won.reservation.dao.ProductDao;
import won.reservation.domain.Product;
import won.reservation.dto.ProductDetailInfo;
import won.reservation.service.ProductService;

@Service
public class ProductServiceImple implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	FileDao fileDao;
	
	@Override
	public List<Product> readProduct() {
		return productDao.select();
	}
	
	@Override
	public ProductDetailInfo readProduct(Integer productId) {
		ProductDetailInfo product = productDao.select(productId);
		product.setProductImg(fileDao.selectByProductId(productId));
		return product;
	}


	@Override
	public int addProduct(Product product) {
		return productDao.insert(product);
	}

	@Override
	public int update(Product product) {
		return productDao.update(product);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return productDao.delete(id);
	}

	@Override
	public int getCount(Integer categoryId) {
		if(categoryId != null) {
			return productDao.getCount(categoryId);
		}
		return productDao.getCount();
	}
	
	@Override
	public Map<String, Object> readProductInfo(Integer start) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", productDao.selectInfo(start));
		map.put("cnt", productDao.getCount());
		return map;
	}
	
	@Override
	public Map<String, Object> readProductInfoCategory(Integer categoryId, Integer start){
		Map<String, Object> map = new HashMap<>();
		map.put("list", productDao.selectInfo(categoryId, start));
		map.put("cnt", productDao.getCount(categoryId));
		return map;
	}

}

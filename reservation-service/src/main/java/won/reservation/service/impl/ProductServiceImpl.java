package won.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.DisplayInfoDao;
import won.reservation.dao.FileDao;
import won.reservation.dao.ProductDao;
import won.reservation.domain.Product;
import won.reservation.dto.ProductDetailInfo;
import won.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;	
	private FileDao fileDao;	
	private DisplayInfoDao displayInfoDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao, FileDao fileDao, DisplayInfoDao displayInfoDao) {
		this.productDao = productDao;
		this.fileDao = fileDao;
		this.displayInfoDao = displayInfoDao;
	}
	
	@Override
	public List<Product> get() {
		return productDao.select();
	}
	
	@Override
	public ProductDetailInfo readProduct(Integer productId) {
		ProductDetailInfo product = productDao.select(productId);
		product.setProductImg(fileDao.selectByProductId(productId));
		product.setDisplayInfo(displayInfoDao.select(productId));
		return product;
	}

	@Override
	public int add(Product product) {
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

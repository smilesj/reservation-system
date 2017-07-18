package won.reservation.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import won.reservation.dao.ProductDao;
import won.reservation.domain.Product;
import won.reservation.service.ProductService;

@Service
public class ProductServiceImple implements ProductService {
	
	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> readProduct() {
		return dao.select();
	}

	@Override
	public int addProduct(Product product) {
		return dao.insert(product);
	}

	@Override
	public int update(Product product) {
		return dao.update(product);
	}

	@Override
	@Transactional
	public int delete(int id) {
		return dao.delete(id);
	}

	@Override
	public int getCount(Integer categoryId) {
		if(categoryId != null) {
			return dao.getCount(categoryId);
		}
		return dao.getCount();
	}
	
	@Override
	public Map<String, Object> readProductInfo(Integer start) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", dao.selectInfo(start));
		map.put("cnt", dao.getCount());
		return map;
	}
	
	@Override
	public Map<String, Object> readProductInfoCategory(Integer categoryId, Integer start){
		Map<String, Object> map = new HashMap<>();
		map.put("list", dao.selectInfo(categoryId, start));
		map.put("cnt", dao.getCount(categoryId));
		return map;
	}

}

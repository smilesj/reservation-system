package won.reservation.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import won.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	int displaynum = 3;
	
	@Autowired
	ProductService service;
	
	@GetMapping("/{start}")
	public Map<String, Object> list(@PathVariable int start) {
		return service.readProductInfo(start*displaynum);
	}

	@GetMapping("/{categoryId}/start/{start}")
	public Map<String, Object> listCategory(@PathVariable(name = "categoryId") int categoryId, @PathVariable(name = "start") int start) {
		return service.readProductInfoCategory(categoryId, start*displaynum);
	}
}

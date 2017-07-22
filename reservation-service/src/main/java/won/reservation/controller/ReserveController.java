package won.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import won.reservation.service.ProductPriceService;
import won.reservation.service.ProductService;

@Controller
public class ReserveController {
	
	private ProductService productService;
	private ProductPriceService productPriceService;
	
	@Autowired
	public ReserveController(ProductService productService, ProductPriceService productPriceService) {
		this.productService = productService;
		this.productPriceService = productPriceService;
	}
	
	@GetMapping
	@RequestMapping("/reserve/{productId}")
	public String main(@PathVariable("productId") Integer productId, Model model) {
		model.addAttribute("product", productService.getProduct(productId));
		model.addAttribute("ticketPrice", productPriceService.get(productId));
		return "reserve";
	}
}

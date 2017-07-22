package won.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import won.reservation.service.ProductPriceService;
import won.reservation.service.ProductService;
import won.reservation.service.UsersService;

@Controller
public class ReserveController {
	
	private ProductService productService;
	private ProductPriceService productPriceService;
	private UsersService usersService;
	
	@Autowired
	public ReserveController(ProductService productService, ProductPriceService productPriceService, UsersService usersService) {
		this.productService = productService;
		this.productPriceService = productPriceService;
		this.usersService = usersService;
	}
	
	@GetMapping
	@RequestMapping("/reserve/{productId}")
	public String main(@PathVariable("productId") Integer productId, Model model, HttpSession session) {
		Integer userId;
		model.addAttribute("product", productService.getProduct(productId));
		model.addAttribute("ticketPrice", productPriceService.get(productId));
		if((userId = (Integer) session.getAttribute("userId")) != null) {		
			model.addAttribute("user", usersService.get(userId));
		}
		return "reserve";
	}
}

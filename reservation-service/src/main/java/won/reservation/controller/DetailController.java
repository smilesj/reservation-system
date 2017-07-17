package won.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import won.reservation.service.FileService;
import won.reservation.service.ProductService;
import won.reservation.service.ReservationUserCommentService;

@Controller
public class DetailController {

	private ProductService productService;
	private ReservationUserCommentService commentService;
	private FileService fileService;

	@Autowired
	public DetailController(ProductService productService, ReservationUserCommentService commentService, FileService fileService) {
		this.productService = productService;
		this.commentService = commentService;
		this.fileService = fileService;
	}
	
	@GetMapping("/products/{productId}")
	public String detail(Model model, @PathVariable(name="productId") Integer productId) {
		model.addAttribute("product", productService.readProduct(productId));
		model.addAttribute("comment", commentService.readReservationUserComment(productId));
		model.addAttribute("avgscore", commentService.getReservationUserCommentAvgScore(productId));
		model.addAttribute("detail", fileService.readProductDetailImgList(productId));
		return "detail";
	}
}

package won.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import won.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("mainpage");
		mav.addObject("category", categoryService.readCategory());
		return mav;
	}
	

}

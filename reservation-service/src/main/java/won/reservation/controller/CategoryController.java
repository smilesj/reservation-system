package won.reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import won.reservation.service.CategoryService;

@Controller
@RequestMapping(value= {"/", "/category"})
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("list", categoryService.readCategory());
		return mav;
	}
	
	@PostMapping
	public String create(@RequestParam String name) {
		if(name == null || "".equals(name)) {
			return "redirect:/";
		}else {
			int result = categoryService.addCategory(name);
			return "redirect:/";
		}
	}
}

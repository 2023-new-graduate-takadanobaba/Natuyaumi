package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ArticleController {
	@RequestMapping(path = "/top")
	public String top() {
		return "top";	
	}
	
	@RequestMapping(path = "/post")
	public String post() {
		return "post";	
	}
	
	
	@RequestMapping(path = "/doPost")
	public String doPost() {
		return "redirect:/post";
	}
	
	
	@RequestMapping(path = "/doSearchGenre", method = RequestMethod.GET)
	public String genre() {
		return "redirect:/genre";
	}
	
	@RequestMapping(path = "/doDisplayAirticle", method = RequestMethod.GET)
	public String airticle() {
		return "redirect:/airticle";
	}
}

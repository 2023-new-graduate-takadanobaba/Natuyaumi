package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.natuyasumi.repository.ArticleRepository;

@Controller

public class ArticleController {
	@Autowired
	ArticleRepository repository;
	
	@RequestMapping(path = "/top")
	public String top() {
		return "top";	
	}
	
	@RequestMapping(path = "/post")
	public String post() {
		return "post";	
	}
	
	
//	@RequestMapping(path = "/post")
//	public String doPost() {
//		return "post";
//	}
	
	
	@RequestMapping(path = "/doSearchGenre", method = RequestMethod.GET)
	public String genre() {
		return "genre";
	}
	
//	@RequestMapping(path = "/doDisplayAirticle", method = RequestMethod.GET)
//	public String airticle() {
//		ArrayList<ArticleEntity> articles = repository.findAll();
//		return "article";
//	}
	
	@RequestMapping(path = "/doDisplayAirticle")
	public String showList(Model model) {
		model.addAttribute("articles", repository.findAll());
		return "article";
	}
}

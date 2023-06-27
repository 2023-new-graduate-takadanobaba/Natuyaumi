package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ArticleController {
	// にゃー
	@RequestMapping(path = "/top")
	 public String top() {
	 return "top";
	}
	
	@RequestMapping(path = "/doSearchGenre")
	 public String doSearchGenre() {
	 return "genre";
	}
	
	@RequestMapping(path = "/returnTop")
	 public String returnTop() {
	 return "top";
	}
	
	@RequestMapping(path = "/post")
	 public String Post() {
	 return "post";
	}
	
	@RequestMapping(path = "/doDisplayAirticle")
	 public String doDisplayAirticle() {
	 return "article";
	}
	
}

package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ArticleController {
	// にゃー
	@RequestMapping(path = "/")
	 public String top() {
	 return "top";
	}
	
	
	
	
	
}

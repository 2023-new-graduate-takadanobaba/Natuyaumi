package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class indexController {
	@RequestMapping(path = "/")
	public String index() {
		return "index";	
	}
	
	@RequestMapping(path = "/index", method = RequestMethod.POST)
	public String doLogin(String userId) {
		System.out.println("ユーザ ID:" + userId);
		return "top";
	}
	
	

}

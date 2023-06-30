package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


	@Controller
	public class MyController {
	    @RequestMapping(value = "/")
	    public String index() {
	        return "index";
	    }
	 
	    @RequestMapping(value = "/login")
	    public String login() {
	        return "login";
	    }
	 
	    @RequestMapping(value = "/newuser")
	    public String newuser() {
	        return "newuser";
	    }
	 
	    @RequestMapping(value = "/mypage")
	    public String top() {
	        return "mypage";
	    }
	}


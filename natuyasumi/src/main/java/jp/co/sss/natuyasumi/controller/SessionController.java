package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	@RequestMapping(path = "/session")
	 public String session() {
	 return "session";
	}
	
}
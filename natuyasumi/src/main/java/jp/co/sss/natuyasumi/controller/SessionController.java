package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {
	
	
	  @Autowired
	  private HttpSession session;

	  @GetMapping
	  public Object getData() {
	    //セッションデータ取得
	    return session.getAttribute("data");
	  }

	}



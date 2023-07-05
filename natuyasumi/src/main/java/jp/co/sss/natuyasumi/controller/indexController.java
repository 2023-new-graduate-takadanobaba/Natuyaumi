package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.natuyasumi.config.SessionData;
import jp.co.sss.natuyasumi.form.PostForm;
import jp.co.sss.natuyasumi.form.userForm;
import jp.co.sss.natuyasumi.repository.ArticleRepository;

@Controller
public class indexController {
	
@Autowired
ArticleRepository repository;

@Autowired
SessionData sessionData;

	
	@PostMapping(value = "/sessionUser")
	public String sessionUser(userForm form, HttpSession session) {
		session.setAttribute("sessionName", form.getUserName());
		return "top";
		
	}

	@GetMapping(value = "/doLogout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "top";
	}
	
	@GetMapping(value = "/moveToMyPage")
	public String moveToMyPage(Model model) {
		model.addAttribute("articles", repository.findAll());
		return "mypage";
	}
	
	 @GetMapping(value="/set")
	    public String set(){
	        sessionData.setStr1("hogehoge");
	        sessionData.setStr2("fugafuga");
	        sessionData.setStr3("piyopiyo");
	        return "index";
	    }
	 
	 @GetMapping(value = "/index")
	    public String index() {
	        return "index";
	    }
	 
	 @PostMapping(value = "//")
	    public void createPost(@RequestParam("session_id") String sessionId, @RequestBody PostForm post) {
//	        post.setSessionId(sessionId);
//	        postRepository.save(post);
	    }
	 
	 @GetMapping(value = "/getSessionId")
	 String GetSessionId(Model model,HttpSession session) {
		 String sessionId = session.getId();
		 model.addAttribute("articles", sessionId);
		return "index";
		 
	 }
	 @GetMapping(value = "/test")
		public String Test(Model model) {
			model.addAttribute("articles", repository.findAll());
			return "test";
		}
	    
	 
	 
	    
}

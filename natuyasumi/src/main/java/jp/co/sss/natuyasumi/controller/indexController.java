package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.natuyasumi.entity.FavoriteEntity;
import jp.co.sss.natuyasumi.form.userForm;
import jp.co.sss.natuyasumi.repository.ArticleRepository;
import jp.co.sss.natuyasumi.repository.FavoriteRepository;

@Controller
public class indexController {
	
@Autowired
ArticleRepository repository;

@Autowired
FavoriteRepository FavRepository;
	
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
	public String moveToMyPage(Model model, HttpSession session) {
	    String sessionId = session.getId();
		model.addAttribute("articles", repository.findAll());
		model.addAttribute("aaa", sessionId);
		return "mypage";
	}
	
	@GetMapping(value = "/addFavoriteList")
	public String addFavoriteList(HttpSession session) {
		FavoriteEntity favorite = new FavoriteEntity();
//		Integer articleId = ;
		String sessionId = session.getId();
		favorite.setId(null);
		favorite.setSessionId(sessionId);
		FavRepository.save(favorite);
		return "article";
	}
	 
	    
	 
	 
	    
}

package jp.co.sss.natuyasumi.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.natuyasumi.entity.ArticleEntity;
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
	public String moveToMyPage(Model model, HttpSession session)throws IOException {
		List<ArticleEntity> articles = repository.findAll();
		model.addAttribute("articles", articles);
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
	    String sessionId = session.getId();
	    model.addAttribute("imageData", genreArticle);
		model.addAttribute("aaa", sessionId);
		model.addAttribute("favorite", FavRepository.findAll());
		return "mypage";
	}
	
	
	
	@GetMapping(value = "/addFavoriteList/{id}")
	public String addFavoriteList(@PathVariable Integer id, HttpSession session,Model model)throws IOException {
		FavoriteEntity favorite = new FavoriteEntity();
		ArticleEntity article = repository.findById(id).get();
		String sessionId = session.getId();
		favorite.setId(id);
		favorite.setSessionId(sessionId);
		FavRepository.save(favorite);
		model.addAttribute("bbb", sessionId);
		model.addAttribute("article", repository.findById(id).get());
		byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
	    String base64Encoded = new String(encodeBase64, "UTF-8");
		model.addAttribute("imageData", base64Encoded);
		model.addAttribute("favorite", favorite.getSessionId());
		return "article";
	}
	
	
	 
	    
	 
	 
	    
}

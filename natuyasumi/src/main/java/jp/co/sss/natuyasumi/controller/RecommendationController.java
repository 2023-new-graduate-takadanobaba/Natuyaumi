package jp.co.sss.natuyasumi.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.repository.ArticleRepository;
import jp.co.sss.natuyasumi.repository.GenreRepository;

@Validated
@Controller
public class RecommendationController {
	
	@Autowired
	ArticleRepository repository;

	@Autowired
	GenreRepository genreRepository;
	
	@GetMapping(path = "/leftRecommendation")
	public String showLeftRecommendation() {
		return "genre";
		
	}
	
	//topページの穴場スポット(左下)
	
	@RequestMapping(path = "/leftRecommendation/{level}")
	 public String showLeftRecommendation(@PathVariable Integer level, Model model)throws IOException {
		List<ArticleEntity> articles = repository.findByLevel(level);
		model.addAttribute("articles", articles);
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
		model.addAttribute("imageData", genreArticle);
		
	 return "genre";
	}
	
	
	//topページの安いスポット(右下)
	@RequestMapping(path = "/rightRecommendation")
	 public String showRightRecommendation(Model model)throws IOException {
		List<ArticleEntity> articles = repository.findAllByOrderByBudgetAsc();
		model.addAttribute("articles", articles);
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
		model.addAttribute("imageData", genreArticle);
		
	 return "genre";
	}
	

	


}

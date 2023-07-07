package jp.co.sss.natuyasumi.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.repository.ArticleRepository;

@Controller
public class AdministratorController {
	@Autowired
	ArticleRepository repository;

	@RequestMapping(path = "/administrator", method = RequestMethod.GET)
	 public String administrator(Model model) throws IOException{
		List<ArticleEntity> articles = repository.findAll();
		model.addAttribute("articles", articles);
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
		model.addAttribute("imageData", genreArticle);
		return "administrator";
	}
	
	@RequestMapping(path = "/displayAirticle/{id}")
	 public String doDisplayAirticle(@PathVariable Integer id, Model model, HttpSession session) throws IOException{
		ArticleEntity article = repository.findById(id).get();
		model.addAttribute("article", article);
		byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
	    String base64Encoded = new String(encodeBase64, "UTF-8");
		model.addAttribute("imageData", base64Encoded);
	 return "administratorArticle";
	}
}

package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.form.PostForm;
import jp.co.sss.natuyasumi.repository.ArticleRepository;
import jp.co.sss.natuyasumi.repository.GenreRepository;

@Controller

public class ArticleController {
	@Autowired
	ArticleRepository repository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@RequestMapping(path = "/top")
	public String top() {
		return "top";	
	}
	
	@RequestMapping(path = "/post")
	public String post() {
		return "post";	
	}
	
	
//	@RequestMapping(path = "/post")
//	public String doPost() {
//		return "post";
//	}
	
	
	@RequestMapping(path = "/doSearchGenre", method = RequestMethod.GET)
	public String genreList(Model model) {
		model.addAttribute("articles", repository.findAll());
		return "genre";
	}
	
//	@RequestMapping(path = "/doDisplayAirticle", method = RequestMethod.GET)
//	public String airticle() {
//		ArrayList<ArticleEntity> articles = repository.findAll();
//		return "article";
//	}
	
	@RequestMapping(path = "/doDisplayAirticle/{id}")
	public String showList(@PathVariable Integer id, Model model) {
		model.addAttribute("article", repository.findById(id).get());
		return "article";
	}
	
	@RequestMapping(path = "/createPost", method = RequestMethod.POST)
	public String createPost(PostForm form, Model model) {
//		System.out.println(form.getGenreId());
		// 1,2,3
		// String[] [1,2,3]
		String[] alt = form.getGenreId().split(",");
		
		ArticleEntity article = new ArticleEntity();
		
		article.setGenre(genreRepository.getReferenceById(Integer.parseInt(alt[0])));
		article.setTitle(form.getTitle());
		article.setName(form.getName());
		article.setAddress(form.getAddress());
		article.setHasParking(form.getHasParking());
		article.setMonth(form.getMonth());
		article.setImageUrl(form.getImageUrl());
		article.setLevel(form.getLevel());
		article.setReview(form.getReview());
		repository.save(article);
//		PostForm postBean = new PostForm();
//		BeanUtils.copyProperties(article, postBean);
		model.addAttribute("articles", article);
		return "genre";
	}
}

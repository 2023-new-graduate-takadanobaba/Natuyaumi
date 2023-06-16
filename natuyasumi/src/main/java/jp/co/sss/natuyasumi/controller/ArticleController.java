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
	
	@RequestMapping(path = "/returnTop")
	public String returnTop() {
		return "top";
	}
	
	
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
	
	@RequestMapping(path = "/delete/{id}")
	public String deletePost(@PathVariable Integer id) {
		repository.deleteById(id);
		return "genre";
	}
	
	@RequestMapping(path = "/createPost", method = RequestMethod.POST)
	public String createPost(PostForm form, Model model) {
//		System.out.println(form.getGenreId());
		// 1,2,3
		// String[] [1,2,3]
//		int max = 10;   //おぞね書いた
		String[] alt = form.getGenreId().split(",");   //PostFormクラスのgenreIdを呼び出して、それをString型配列altに格納
		
		ArticleEntity article = new ArticleEntity();   //ArticleEntityのオブジェクト生成
		
		article.setGenre(genreRepository.getReferenceById(Integer.parseInt(alt[0])));
//		String型配列altをIntegerに変換してGenreテーブルのIdを探してsetGenreでarticleに格納している
//		if(article.getGenre1() != null) {
		
//		article.setGenre1(genreRepository.getReferenceById(Integer.parseInt(alt[1])));
//		}
//		if(article.getGenre2() != null) {
		
//		article.setGenre2(genreRepository.getReferenceById(Integer.parseInt(alt[2])));
//		}
		
//		ここから小曽根
//		for(int i = 0; i  < max; i++) {
//			if(i<max) {
//				alt[i] = 
//			}
//		}
//		article.setGenre3(genreRepository.getReferenceById(Integer.parseInt(alt[3])));
//		article.setGenre4(genreRepository.getReferenceById(Integer.parseInt(alt[4])));
//		article.setGenre5(genreRepository.getReferenceById(Integer.parseInt(alt[5])));
//		article.setGenre6(genreRepository.getReferenceById(Integer.parseInt(alt[6])));
//		article.setGenre7(genreRepository.getReferenceById(Integer.parseInt(alt[7])));
//		article.setGenre8(genreRepository.getReferenceById(Integer.parseInt(alt[8])));
//		article.setGenre9(genreRepository.getReferenceById(Integer.parseInt(alt[9])));
		article.setTitle(form.getTitle());
		article.setName(form.getName());
		article.setAddress(form.getAddress());
		article.setHasParking(form.getHasParking());
		article.setMonth(form.getMonth());
		article.setImageUrl(form.getImageUrl());
		article.setLevel(form.getLevel());
		article.setReview(form.getReview());
//		BeanUtils.copyProperties(form,article);
		repository.save(article);    //articleの内容をDBに格納
//		PostForm postBean = new PostForm();
//		BeanUtils.copyProperties(article, postBean);
		model.addAttribute("articles", article);    //articleの内容を"articles"に格納
		return "genre";
	}
}

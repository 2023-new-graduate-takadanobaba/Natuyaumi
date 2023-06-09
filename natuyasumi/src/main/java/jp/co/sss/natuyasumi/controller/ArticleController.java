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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.entity.Genre;
import jp.co.sss.natuyasumi.form.PostForm;
import jp.co.sss.natuyasumi.repository.ArticleRepository;
import jp.co.sss.natuyasumi.repository.FavoriteRepository;
import jp.co.sss.natuyasumi.repository.GenreRepository;

@Validated
@Controller

public class ArticleController implements WebMvcConfigurer{
	
	// にゃー
	@Autowired
	ArticleRepository repository;

	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	FavoriteRepository FavRepository;
	
	@GetMapping(path = "/top")
	 public String top() {
	 return "top";
	}
	@RequestMapping(path = "/doSearchGenre", method = RequestMethod.GET)
	 public String doSearchGenre( Model model) throws IOException {
		
		List<ArticleEntity> articles = repository.findAll();
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
	
	@RequestMapping(path = "/returnTop")
	 public String returnTop() {
	 return "top";
	}
	
	@RequestMapping(path = "/post",method = RequestMethod. GET)
	 public String Post(@ModelAttribute PostForm form) {
	 return "post";
	}
	
	@RequestMapping(path = "/doDisplayAirticle/{id}")
	 public String doDisplayAirticle(@PathVariable Integer id, Model model, HttpSession session) throws IOException{
		String sessionId = session.getId();
		ArticleEntity article = repository.findById(id).get();
		model.addAttribute("article", article);
		model.addAttribute("bbb", sessionId);
		byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
	    String base64Encoded = new String(encodeBase64, "UTF-8");
		model.addAttribute("imageData", base64Encoded);
	 return "article";
	}
	
	@RequestMapping(path = "/createPost", method = RequestMethod.POST)
	 public String doCreatePost(@RequestParam ("imageData") MultipartFile imageData, Model model, PostForm form, HttpSession session) throws IOException {
		
		ArticleEntity article = new ArticleEntity();
		
		
		String[] alt = form.getGenreId().split(",");
		
		article.setGenre(genreRepository.getReferenceById(Integer.parseInt(alt[0])));
		
		if(alt.length > 1) {
			article.setGenre1(genreRepository.getReferenceById(Integer.parseInt(alt[1])));
		}
		
		if(alt.length > 2) {
			article.setGenre2(genreRepository.getReferenceById(Integer.parseInt(alt[2])));
		}
		
		if(alt.length > 3) {
			article.setGenre3(genreRepository.getReferenceById(Integer.parseInt(alt[3])));
		}
		
		if(alt.length > 4) {
			article.setGenre4(genreRepository.getReferenceById(Integer.parseInt(alt[4])));
		}
		
		if(alt.length > 5) {
			article.setGenre5(genreRepository.getReferenceById(Integer.parseInt(alt[5])));
		}
		
		if(alt.length > 6) {
			article.setGenre6(genreRepository.getReferenceById(Integer.parseInt(alt[6])));
		}
		
		if(alt.length > 7) {
			article.setGenre7(genreRepository.getReferenceById(Integer.parseInt(alt[7])));
		}
		
		if(alt.length > 8) {
			article.setGenre8(genreRepository.getReferenceById(Integer.parseInt(alt[8])));
		}
		
		if(alt.length > 9) {
			article.setGenre9(genreRepository.getReferenceById(Integer.parseInt(alt[9])));
		}
		
		String sessionId = session.getId();
		
		article.setTitle(form.getTitle());
		article.setName(form.getName());
		article.setAddress(form.getAddress());
		article.setHasParking(form.getHasParking());
		article.setMonth(form.getMonth());
		article.setBudget(form.getBudget());
		article.setImageData(imageData.getBytes());
		article.setLevel(form.getLevel());
		article.setReview(form.getReview());
		article.setSessionId(sessionId);
		article.setTranspotation(form.getTranspotation());
		article.setWithSomeone(form.getWithSomeone());
		

		repository.save(article);
		
		List<ArticleEntity> articles = repository.findAll();
		model.addAttribute("articles", articles);
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity articless : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(articless.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(articless.getId(), base64Encoded);
		}
		
		model.addAttribute("imageData", genreArticle);
		model.addAttribute("articles", article);

		return "genre";
	}
	

	
	@RequestMapping(path = "/delete/{id}")
	 public String doDelete(@PathVariable Integer id, Model model) {
		repository.deleteById(id);
	 return "genre";
	}
	
	
	
	@RequestMapping(path = "/doSearchGenre/{genreId}")
	 public String doSearchGenre(@PathVariable Integer genreId, Model model)throws IOException {
		Genre genre = new Genre();
		genre.setGenreId(genreId);
		List<ArticleEntity> articles = repository.findByGenre(genre);
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
	
	
	
	
	
	@RequestMapping(path = "/doSearchAddress/{address}")
	 public String doSearchAddress(@PathVariable String address, Model model)throws IOException  {
		List<ArticleEntity> articles = repository.findByAddressContaining(address);
		model.addAttribute("articles",articles );
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
		model.addAttribute("imageData", genreArticle);
		return "genre";
	 
	}
	
	@RequestMapping(value = "/doSearchKeyWord",method = RequestMethod.POST)
	public String doSearchKeyWord(@RequestParam String name,Model model) throws IOException {	
		List<ArticleEntity> articles = repository.findByNameContaining(name);
		model.addAttribute("articles",articles);
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
		model.addAttribute("imageData", genreArticle);
		return "genre";
		
	}
	
	@RequestMapping(value = "/searchTranspotation/{transpotation}")
	public String searchTranspotation(@PathVariable Integer transpotation, Model model) throws IOException {
		List<ArticleEntity> articles = repository.findByTranspotation(transpotation);
		model.addAttribute("articles",articles );
		HashMap<Integer,String> genreArticle = new HashMap<>();
		for(ArticleEntity article : articles) {
			byte[] encodeBase64 = Base64.getEncoder().encode(article.getImageData());
		    String base64Encoded = new String(encodeBase64, "UTF-8");
		    genreArticle.put(article.getId(), base64Encoded);
		}
		model.addAttribute("imageData", genreArticle);
		return "genre";
	}
	
	@RequestMapping(value = "/withSomeone/{withSomeone}")
	public String withSomeone(@PathVariable Integer withSomeone, Model model) throws IOException {
		List<ArticleEntity> articles = repository.findByWithSomeone(withSomeone);
		model.addAttribute("articles",articles );
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

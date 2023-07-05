package jp.co.sss.natuyasumi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.entity.Genre;
import jp.co.sss.natuyasumi.form.PostForm;
import jp.co.sss.natuyasumi.repository.ArticleRepository;
import jp.co.sss.natuyasumi.repository.GenreRepository;

@Validated
@Controller

public class ArticleController implements WebMvcConfigurer{
	
	// にゃー
	@Autowired
	ArticleRepository repository;

	@Autowired
	GenreRepository genreRepository;
	
	@GetMapping(path = "/top")
	 public String top() {
	 return "top";
	}
	@RequestMapping(path = "/doSearchGenre", method = RequestMethod.GET)
	 public String doSearchGenre(Model model) {
		model.addAttribute("articles", repository.findAll());
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
	 public String doDisplayAirticle(@PathVariable Integer id, Model model) {
		model.addAttribute("article", repository.findById(id).get());
	 return "article";
	}
	
	
	
	@RequestMapping(path = "/createPost", method = RequestMethod.POST)
	 public String doCreatePost(Model model, @Valid PostForm form, HttpSession session,
			 BindingResult result) {
		if(result.hasErrors()) {
			return "Post";


		}
		
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
		article.setImageUrl(form.getImageUrl());
		article.setLevel(form.getLevel());
		article.setReview(form.getReview());
		
		article.setSessionId(sessionId);
		

		repository.save(article);
		model.addAttribute("articles", article);

		return "genre";
	}
	

	
	@RequestMapping(path = "/delete/{id}")
	 public String doDelete(@PathVariable Integer id, Model model) {
		repository.deleteById(id);
	 return "genre";
	}
	
	
	
	@RequestMapping(path = "/doSearchGenre/{genreId}")
	 public String doSearchGenre(@PathVariable Integer genreId, Model model) {
		Genre genre = new Genre();
		genre.setGenreId(genreId);
		List<ArticleEntity> drive = repository.findByGenre(genre);
		model.addAttribute("articles", drive);
	 return "genre";
	}
	
	@RequestMapping(path = "/doSearchAddress/{address}")
	 public String doSearchAddress(@PathVariable String address, Model model) {
		model.addAttribute("articles", repository.findByAddressContaining(address));
		return "genre";
	 
	}
	
	@RequestMapping(value = "/doSearchKeyWord",method = RequestMethod.POST)
	public String doSearchKeyWord(@RequestParam String name,Model model) {	
		model.addAttribute("articles", repository.findByNameContaining(name));
		return "genre";
		
	}
	
	

	
	
	
}

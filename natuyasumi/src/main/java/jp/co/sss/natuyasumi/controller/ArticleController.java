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
	 public String doCreatePost(Model model, @Valid PostForm form, 
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
		
		article.setTitle(form.getTitle());
		article.setName(form.getName());
		article.setAddress(form.getAddress());
		article.setHasParking(form.getHasParking());
		article.setMonth(form.getMonth());
		article.setImageUrl(form.getImageUrl());
		article.setLevel(form.getLevel());
		article.setReview(form.getReview());
		
		
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
		//ここに表示できる投稿がない場合、if文を入れたい
		model.addAttribute("articles", repository.findByAddressContaining(address));
		return "genre";
	 
	}
	
	@RequestMapping(value = "/doSearchKeyWord",method = RequestMethod.POST)
	public String doSearchKeyWord(@RequestParam String name,Model model) {	
		model.addAttribute("articles", repository.findByNameContaining(name));
		return "genre";
		
	}
	
	@GetMapping(value = "/InsertGenreColumn")
	public String insertGenreColumn() {
		Genre genre = new Genre();
		genre.setGenreId(1);
		genre.setGenreName("ドライブ");
		genreRepository.save(genre);
		Genre genre1 = new Genre();
		genre1.setGenreId(2);
		genre1.setGenreName("歴史、遺産");
		genreRepository.save(genre1);
		Genre genre2 = new Genre();
		genre2.setGenreId(3);
		genre2.setGenreName("自然、公園");
		genreRepository.save(genre2);
		Genre genre3 = new Genre();
		genre3.setGenreId(4);
		genre3.setGenreName("動物園、水族館");
		genreRepository.save(genre3);
		Genre genre4 = new Genre();
		genre4.setGenreId(5);
		genre4.setGenreName("観光名所");
		genreRepository.save(genre4);
		Genre genre5 = new Genre();
		genre5.setGenreId(6);
		genre5.setGenreName("アクティビティ、体験");
		genreRepository.save(genre5);
		Genre genre6 = new Genre();
		genre6.setGenreId(7);
		genre6.setGenreName("レジャー施設");
		genreRepository.save(genre6);
		Genre genre7 = new Genre();
		genre7.setGenreId(8);
		genre7.setGenreName("アミューズメント、テーマパーク");
		genreRepository.save(genre7);
		Genre genre8 = new Genre();
		genre8.setGenreId(9);
		genre8.setGenreName("アート、文化");
		genreRepository.save(genre8);
		Genre genre9 = new Genre();
		genre9.setGenreId(10);
		genre9.setGenreName("ショッピング");
		genreRepository.save(genre9);
		Genre genre10 = new Genre();
		genre10.setGenreId(11);
		genre10.setGenreName("レストラン、カフェ");
		genreRepository.save(genre10);
		Genre genre11 = new Genre();
		genre11.setGenreId(12);
		genre11.setGenreName("居酒屋");
		genreRepository.save(genre11);
		Genre genre12 = new Genre();
		genre12.setGenreId(13);
		genre12.setGenreName("リラックス、温泉");
		genreRepository.save(genre12);
		Genre genre13 = new Genre();
		genre13.setGenreId(14);
		genre13.setGenreName("映像");
		genreRepository.save(genre13);
		Genre genre14 = new Genre();
		genre14.setGenreId(15);
		genre14.setGenreName("ゲーム");
		genreRepository.save(genre14);
		Genre genre15 = new Genre();
		genre15.setGenreId(16);
		genre15.setGenreName("車が便利");
		genreRepository.save(genre15);
		Genre genre16 = new Genre();
		genre16.setGenreId(17);
		genre16.setGenreName("公共交通機関で行ける");
		genreRepository.save(genre16);
		Genre genre17 = new Genre();
		genre17.setGenreId(18);
		genre17.setGenreName("2-5人で楽しめる");
		genreRepository.save(genre17);
		Genre genre18 = new Genre();
		genre18.setGenreId(19);
		genre18.setGenreName("一人で楽しめる");
		genreRepository.save(genre18);
		Genre genre19 = new Genre();
		genre19.setGenreId(20);
		genre19.setGenreName("大人数可");
		genreRepository.save(genre19);
		Genre genre20 = new Genre();
		genre20.setGenreId(21);
		genre20.setGenreName("予約可");
		genreRepository.save(genre20);
		return "top";
	}

	
	
	
}

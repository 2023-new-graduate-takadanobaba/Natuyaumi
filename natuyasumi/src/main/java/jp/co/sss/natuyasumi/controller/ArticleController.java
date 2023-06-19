package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.entity.Genre;
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

						//		 HttpServletRequest request,
//		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//	     MultipartFile image = multipartRequest.getFile("imageUrl");
//	     
//	     if (image != null && !image.isEmpty()) {
//	                String filePath = "genre"; // 画像を保存するパス
//	                try {
//						image.transferTo(new File(filePath));
						
//						
						ArticleEntity article = new ArticleEntity();
//						article.setImageUrl(filePath);
////						repository.save(article); 
						
//						List<ArticleEntity> articles = ImageService.getAllImages();
//						
						
						
					

//		System.out.println(form.getGenreId());
		// 1,2,3
		// String[] [1,2,3]
		String[] alt = form.getGenreId().split(",");   //PostFormクラスのgenreIdを呼び出して、それをString型配列altに格納
		
//		ArticleEntity article = new ArticleEntity();//ArticleEntityのオブジェクト生成
		
		
//		article.setGenre(genreRepository.getReferenceById(Integer.parseInt(alt[0])));
		//一行で書く場合はこうやって書く。
//		String型配列altをIntegerに変換してGenreテーブルのIdを探してsetGenreでarticleに格納している
		
		int i = Integer.parseInt(alt[0]);
		Genre genreReference = genreRepository.getReferenceById(i);
		article.setGenre(genreReference);
		
		if(alt.length > 1) {
			int i1 = Integer.parseInt(alt[1]);
			Genre genreReference1 = genreRepository.getReferenceById(i1);
			article.setGenre1(genreReference1);
		}
		
		if(alt.length > 2) {
			int i2 = Integer.parseInt(alt[2]);
			Genre genreReference2 = genreRepository.getReferenceById(i2);
			article.setGenre2(genreReference2);
		}
		
		if(alt.length > 3) {
			int i3 = Integer.parseInt(alt[3]);
			Genre genreReference3 = genreRepository.getReferenceById(i3);
			article.setGenre3(genreReference3);
		}
		
		if(alt.length > 4) {
			int i4 = Integer.parseInt(alt[4]);
			Genre genreReference4 = genreRepository.getReferenceById(i4);
			article.setGenre4(genreReference4);
		}
		
		if(alt.length > 5) {
			int i5 = Integer.parseInt(alt[5]);
			Genre genreReference5 = genreRepository.getReferenceById(i5);
			article.setGenre5(genreReference5);
		}
		
		if(alt.length > 6) {
			int i6 = Integer.parseInt(alt[6]);
			Genre genreReference6 = genreRepository.getReferenceById(i6);
			article.setGenre6(genreReference6);
		}
		
		if(alt.length > 7) {
			int i7 = Integer.parseInt(alt[7]);
			Genre genreReference7 = genreRepository.getReferenceById(i7);
			article.setGenre7(genreReference7);
		}
		
		if(alt.length > 8) {
			int i8 = Integer.parseInt(alt[8]);
			Genre genreReference8 = genreRepository.getReferenceById(i8);
			article.setGenre8(genreReference8);
		}
		
		if(alt.length > 9) {
			int i9 = Integer.parseInt(alt[9]);
			Genre genreReference9 = genreRepository.getReferenceById(i9);
			article.setGenre9(genreReference9);
		}
		
		
//		int altValue = Integer.parseInt(alt[1]);
//		if(alt [1] !=  null) {
//		Genre genreReference = genreRepository.getReferenceById(altValue);
//		article.setGenre1(genreReference);
//		} //これは間違いでalt[1]にそもそも値が入らないことでエラーになる。
		

//		String型配列altをIntegerに変換してGenreテーブルのIdを探してsetGenreでarticleに格納している
		
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
//		article.setImageData(form.getImageData());
		article.setLevel(form.getLevel());
		article.setReview(form.getReview());
//		BeanUtils.copyProperties(form,article);
		repository.save(article);    //articleの内容をDBに格納
//		PostForm postBean = new PostForm();
//		BeanUtils.copyProperties(article, postBean);
		model.addAttribute("articles", article);    //articleの内容を"articles"に格納
		return "genre";
		
//	                } catch (IllegalStateException | IOException e) {
//						// TODO 自動生成された catch ブロック
//						e.printStackTrace();
//					}
//	     }
//		return "genre";
	}
}

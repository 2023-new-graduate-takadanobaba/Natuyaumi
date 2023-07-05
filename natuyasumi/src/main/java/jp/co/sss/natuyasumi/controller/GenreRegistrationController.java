package jp.co.sss.natuyasumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.natuyasumi.entity.Genre;
import jp.co.sss.natuyasumi.repository.GenreRepository;

@Controller
public class GenreRegistrationController {
	@Autowired
	GenreRepository genreRepository;

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
package jp.co.sss.natuyasumi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity    //Formクラスと対応している
@Table(name = "article")

public class ArticleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //MySQLの連番のつけ方。これをつけないとエラー
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_article_gen")
//	@SequenceGenerator(name = "seq_article_gen", sequenceName = "seq_article", allocationSize = 1)
	private Integer id;
	 @Column
	 private String title;
	 
	 @Column
	 private String name;
	 
	 @Column
	 private String address;
	 
	 @Column
	 private Boolean hasParking;
	 
	 @Column
	 private Integer month;
	 
	 @Column
	 private String imageUrl;
	 
//	 @Lob
//	  @Column(name = "image_data", nullable = false)
//	  private byte[] imageData;
	 
	 @Column
	 private Integer level;
	 
//	 @Column   //GenreIdは外部参照で引っ張ってきているからいらない
//	 private Integer genreId;
	 
	 @Column
	 private String review;
	 
	 @Column
	 private String sessionId;
	 
//	 MySQLのname=Articleテーブル、ReferencedColumnName=Genreテーブルと対応させる
//	 テーブルが二つあるからそれを対応させている
	 
	 @ManyToOne
	 @JoinColumn(name = "genre_id", referencedColumnName = "genreId")
	 private Genre genre;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_01", referencedColumnName = "genreId")
	 private Genre genre1;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_02", referencedColumnName = "genreId")
	 private Genre genre2;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_03", referencedColumnName = "genreId")
	 private Genre genre3;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_04", referencedColumnName = "genreId")
	 private Genre genre4;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_05", referencedColumnName = "genreId")
	 private Genre genre5;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_06", referencedColumnName = "genreId")
	 private Genre genre6;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_07", referencedColumnName = "genreId")
	 private Genre genre7;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_08", referencedColumnName = "genreId")
	 private Genre genre8;
	 @ManyToOne
	 @JoinColumn(name = "genre_id_09", referencedColumnName = "genreId")
	 private Genre genre9;
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getHasParking() {
		return hasParking;
	}

	public void setHasParking(Boolean hasParking) {
		this.hasParking = hasParking;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}

//	public Integer getGenreId() {
//		return genreId;
//	}
//
//	public void setGenreId(Integer genreId) {
//		this.genreId = genreId;
//	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Genre getGenre1() {
		return genre1;
	}

	public void setGenre1(Genre genre1) {
		this.genre1 = genre1;
	}

	public Genre getGenre2() {
		return genre2;
	}

	public void setGenre2(Genre genre2) {
		this.genre2 = genre2;
	}

	public Genre getGenre3() {
		return genre3;
	}

	public void setGenre3(Genre genre3) {
		this.genre3 = genre3;
	}

	public Genre getGenre4() {
		return genre4;
	}

	public void setGenre4(Genre genre4) {
		this.genre4 = genre4;
	}

	public Genre getGenre5() {
		return genre5;
	}

	public void setGenre5(Genre genre5) {
		this.genre5 = genre5;
	}

	public Genre getGenre6() {
		return genre6;
	}

	public void setGenre6(Genre genre6) {
		this.genre6 = genre6;
	}

	public Genre getGenre7() {
		return genre7;
	}

	public void setGenre7(Genre genre7) {
		this.genre7 = genre7;
	}

	public Genre getGenre8() {
		return genre8;
	}

	public void setGenre8(Genre genre8) {
		this.genre8 = genre8;
	}

	public Genre getGenre9() {
		return genre9;
	}

	public void setGenre9(Genre genre9) {
		this.genre9 = genre9;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	 
	

}



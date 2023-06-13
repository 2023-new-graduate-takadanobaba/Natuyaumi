package jp.co.sss.natuyasumi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "article")

public class ArticleEntity {
	@Id
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
	 
	 @Column
	 private Integer level;
	 
	 @Column
	 private Integer genreId;
	 
	 @Column
	 private String review;

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

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	 

}

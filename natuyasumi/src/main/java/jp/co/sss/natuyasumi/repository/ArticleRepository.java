package jp.co.sss.natuyasumi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.natuyasumi.entity.ArticleEntity;
import jp.co.sss.natuyasumi.entity.Genre;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{
	
	Optional<ArticleEntity> findById(Integer id);
	List<ArticleEntity> findByGenre(Genre genre);
	List<ArticleEntity> findByAddressContaining(String address);
	List<ArticleEntity> findByTitleContaining(String title);

}

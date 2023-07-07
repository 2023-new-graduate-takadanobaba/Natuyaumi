package jp.co.sss.natuyasumi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.natuyasumi.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{
	List<Genre>findByGenreNameContaining(String genreName);
	
}

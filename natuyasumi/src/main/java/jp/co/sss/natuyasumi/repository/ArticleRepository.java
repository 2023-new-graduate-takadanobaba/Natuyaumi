package jp.co.sss.natuyasumi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.natuyasumi.entity.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{

}

package jp.co.sss.natuyasumi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.natuyasumi.entity.FavoriteEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Integer>{

}

package jp.co.sss.natuyasumi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.natuyasumi.entity.User;

public interface AuthenticationManager extends JpaRepository<User, Integer>{

}

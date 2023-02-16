package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

	// JPA는 SQL 쿼리를 사용하지 않고 JPA 메소드가 SQL 쿼리로 변환해서 처리
	//findAll()
	//findById()
	//save() <== Insert, Update
	//delete() <== delete
	
	//로그인 ㅓ리하기 위해서 사용자 정보를 입력 받아서 DataBase에서 Select 해서 SiteUser 객체에 저장함.
	Optional<SiteUser> findByusername(String username);
}

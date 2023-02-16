package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

//사용자 정보를 폼에서 넘겨 받아서 인증을 처리함.

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<SiteUser> _siteUser = this.userRepository.findByusername(username);
		
		if(_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
		}
		
		//폼에서 넘어오는 username을 DB에서 쿼리해서 siteUser 객체에 담은 값을 Optional에서 뽑아옴 
		//siteUser : DB에서 select 한 레코드
		SiteUser siteUser = _siteUser.get();
		
		//Authentication (인증) : Identity (ID) + Password를 확인 하는 것
		//Authorization (허가) : 인증한 사용자에게 사이트의 서비스를 쏠 수 있도록 권한을 부여하는 것
			// 계정이 admin 이 라면 ADMIN Role을 적용
			// 계정이 admin 이 아니라면 USER Role을 적용
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if("admin".equals(username)) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		
		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
	}
}

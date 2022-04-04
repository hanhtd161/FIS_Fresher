//package com.fis.project.security;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fis.project.entity.Detective;
//import com.fis.project.entity.Person;
//
//public class CustomUserDetails implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//	
//	private Person person;
//	private Collection<? extends GrantedAuthority> authorities;
//	
//	public CustomUserDetails(Person person,Detective detective) {
//		this.person = person;
//		Set<GrantedAuthority> setAuthorities = new HashSet<>();
//		setAuthorities.add(new SimpleGrantedAuthority("USER"));
//		if(detective != null) {
//			setAuthorities.add( new SimpleGrantedAuthority(detective.getRank().name()));
//		}
//		this.authorities = setAuthorities;
//		
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return person.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return person.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}

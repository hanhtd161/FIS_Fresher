//package com.fis.project.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.fis.project.entity.Detective;
//import com.fis.project.entity.Person;
//import com.fis.project.repo.DetectiveRepo;
//import com.fis.project.service.PersonService;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//	@Autowired
//	private PersonService personService;
//	
//	@Autowired
//	private DetectiveRepo detectiveRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Detective detective = detectiveRepo.findByPerson_Username(username).orElse(null);
//		Person person = personService.findByUsername(username);
//		return new CustomUserDetails(person, detective);
//	}
//	
//	
//}

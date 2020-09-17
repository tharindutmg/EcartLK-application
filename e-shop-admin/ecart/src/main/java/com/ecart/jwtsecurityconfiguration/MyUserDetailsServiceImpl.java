package com.ecart.jwtsecurityconfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecart.domain.Stakeholder;
import com.ecart.repo.StakeholderRepo;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	public StakeholderRepo stakeholderRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Stakeholder user = stakeholderRepo.findByUserNameIgnoreCase(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("no User found with user name %s", username));
		}
		return new User(user.getUserName(), user.getPassword(),
				maptoGeneratedAuthorites(new ArrayList<String>(Arrays.asList(user.getStakeholderType()))));
		

	}

	private static List<GrantedAuthority> maptoGeneratedAuthorites(ArrayList<String> authorities) {
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority))
				.collect(Collectors.toList());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}

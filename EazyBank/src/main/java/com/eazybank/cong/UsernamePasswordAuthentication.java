package com.eazybank.cong;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eazybank.model.Customer;
import com.eazybank.model.Role;
import com.eazybank.repo.CustomerRepo;

@Component
public class UsernamePasswordAuthentication implements AuthenticationProvider {
    
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	     String name = authentication.getName();
	        String pwd = authentication.getCredentials().toString();
	        List<Customer> customer = customerRepo.findByName(name);
	        if (customer.size() > 0) {
	            if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
	                return new UsernamePasswordAuthenticationToken(name, pwd, getGrantedAuthorities(customer.get(0).getRole()));
	            } else {
	                throw new BadCredentialsException("Invalid password!");
	            }
	        }else {
	            throw new BadCredentialsException("No user registered with this details!");
	        }
	    }

	    private List<GrantedAuthority> getGrantedAuthorities(Set<Role> roles) {
	        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	        for (Role role : roles) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
	        }
	        return grantedAuthorities;
	    }
	

	@Override
	public boolean supports(Class<?> authentication) {
		  return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
